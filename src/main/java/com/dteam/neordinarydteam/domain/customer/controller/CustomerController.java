package com.dteam.neordinarydteam.domain.customer.controller;

import com.dteam.neordinarydteam.domain.customer.dto.request.CustomerRequest;
import com.dteam.neordinarydteam.domain.customer.dto.response.CustomerResponse;
import com.dteam.neordinarydteam.domain.customer.exception.code.CustomerErrorCode;
import com.dteam.neordinarydteam.domain.customer.service.command.CustomerCommandService;
import com.dteam.neordinarydteam.domain.customer.service.query.CustomerQueryService;
import com.dteam.neordinarydteam.global.apiPayload.code.ErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import com.dteam.neordinarydteam.global.swagger.annotation.ApiErrorCodeExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Customer", description = "Customer API")
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerCommandService customerCommandService;
    private final CustomerQueryService customerQueryService;

    @Operation(summary = "고객 생성 API", description = "새로운 고객 정보를 생성하고 Member 권한을 부여합니다.")
    @ApiErrorCodeExamples(value = {ErrorCode.INVALID_TYPE_VALUE})
    @PostMapping
    public ApiResponse<CustomerResponse.CreateDTO> createCustomer(@Valid @RequestBody CustomerRequest.CreateDTO dto) {
        return ApiResponse.onSuccess(SuccessCode.CREATED, customerCommandService.createCustomer(dto));
    }

    @Operation(summary = "고객 정보 수정 API", description = "고객의 큐레이션 및 활동 지역 설정을 수정합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            customer = {CustomerErrorCode.CUSTOMER_NOT_FOUND})
    @PatchMapping("/{uuid}")
    public ApiResponse<CustomerResponse.UpdateDTO> updateCustomer(
            @Parameter(description = "고객의 회원 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000")
                    @PathVariable
                    @NotNull(message = "UUID는 필수 값입니다.")
                    UUID uuid,
            @Valid @RequestBody CustomerRequest.UpdateDTO dto) {
        return ApiResponse.onSuccess(SuccessCode.OK, customerCommandService.updateCustomer(uuid, dto));
    }

    @Operation(summary = "고객 삭제(탈퇴) API", description = "고객 정보를 시스템에서 삭제합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            customer = {CustomerErrorCode.CUSTOMER_NOT_FOUND})
    @DeleteMapping("/{uuid}")
    public ApiResponse<CustomerResponse.DeleteDTO> deleteCustomer(
            @Parameter(description = "고객의 회원 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000")
                    @PathVariable
                    @NotNull(message = "UUID는 필수 값입니다.")
                    UUID uuid) {
        return ApiResponse.onSuccess(SuccessCode.OK, customerCommandService.deleteCustomer(uuid));
    }

    @Operation(summary = "고객 프로필 조회 API", description = "회원 고유 UUID를 기반으로 고객 프로필 상세 정보를 조회합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            customer = {CustomerErrorCode.CUSTOMER_NOT_FOUND})
    @GetMapping("/{uuid}")
    public ApiResponse<CustomerResponse.MyProfileDTO> getMyProfile(
            @Parameter(description = "고객의 회원 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000")
                    @PathVariable
                    @NotNull(message = "UUID는 필수 값입니다.")
                    UUID uuid) {
        return ApiResponse.onSuccess(SuccessCode.OK, customerQueryService.getMyProfile(uuid));
    }
}
