package com.dteam.neordinarydteam.domain.like.controller;

import com.dteam.neordinarydteam.domain.customer.exception.code.CustomerErrorCode;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.like.dto.request.LikeRequest;
import com.dteam.neordinarydteam.domain.like.dto.response.LikeResponse;
import com.dteam.neordinarydteam.domain.like.service.command.LikeCommandService;
import com.dteam.neordinarydteam.domain.like.service.query.LikeQueryService;
import com.dteam.neordinarydteam.global.apiPayload.code.ErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import com.dteam.neordinarydteam.global.swagger.annotation.ApiErrorCodeExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Like", description = "Like API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/likes")
public class LikeController {
    private final LikeCommandService likeCommandService;
    private final LikeQueryService likeQueryService;

    @Operation(summary = "찜 생성 API", description = "고객 UUID와 시설물 ID를 받아 찜 관계를 신규 등록합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            customer = {CustomerErrorCode.CUSTOMER_NOT_FOUND},
            facility = {FacilityErrorCode.FACILITY_NOT_FOUND})
    @PostMapping
    public ApiResponse<Void> createLike(@Valid @RequestBody LikeRequest.CreateDTO dto) {
        likeCommandService.createLike(dto);
        return ApiResponse.onSuccess(SuccessCode.CREATED, null);
    }

    @Operation(summary = "찜 취소(삭제) API", description = "고객 UUID와 시설물 ID를 통해 기존의 찜 내역을 삭제합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            customer = {CustomerErrorCode.CUSTOMER_NOT_FOUND},
            facility = {FacilityErrorCode.FACILITY_NOT_FOUND})
    @DeleteMapping
    public ApiResponse<Void> deleteLike(
            @Parameter(description = "고객 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000")
                    @RequestParam
                    @NotNull(message = "고객 UUID는 필수입니다.")
                    UUID uuid,
            @Parameter(description = "시설물 고유 ID", example = "1") @RequestParam @NotNull(message = "시설물 ID는 필수입니다.")
                    Long facilityId) {
        likeCommandService.deleteLike(uuid, facilityId);
        return ApiResponse.onSuccess(SuccessCode.OK, null);
    }

    @Operation(summary = "단일 시설물 찜 여부 확인 API", description = "특정 시설물에 대해 해당 고객이 찜을 눌렀는지 상태를 반환합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            customer = {CustomerErrorCode.CUSTOMER_NOT_FOUND})
    @GetMapping
    public ApiResponse<LikeResponse.ExistDTO> getExistsLike(
            @Parameter(description = "고객 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000")
                    @RequestParam
                    @NotNull(message = "고객 UUID는 필수입니다.")
                    UUID uuid,
            @Parameter(description = "시설물 고유 ID", example = "1") @RequestParam @NotNull(message = "시설물 ID는 필수입니다.")
                    Long facilityId) {
        return ApiResponse.onSuccess(SuccessCode.OK, likeQueryService.getExistsLike(uuid, facilityId));
    }

    @Operation(summary = "나의 찜 목록 페이징 조회 API", description = "내가 찜한 시설물 리스트를 페이징 형태로 반환합니다. (기본 최신순 정렬)")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            customer = {CustomerErrorCode.CUSTOMER_NOT_FOUND})
    @GetMapping("/me")
    public ApiResponse<PageResponse<LikeResponse.MyDTO>> getMyLikes(
            @Parameter(description = "고객 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000")
                    @RequestParam
                    @NotNull(message = "고객 UUID는 필수입니다.")
                    UUID uuid,
            @ParameterObject @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
                    Pageable pageable) {
        return ApiResponse.onSuccess(SuccessCode.OK, likeQueryService.getMyLikes(uuid, pageable));
    }
}
