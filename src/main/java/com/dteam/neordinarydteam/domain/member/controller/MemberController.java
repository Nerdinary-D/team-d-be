package com.dteam.neordinarydteam.domain.member.controller;

import com.dteam.neordinarydteam.domain.member.dto.response.MemberResponse;
import com.dteam.neordinarydteam.domain.member.exception.code.MemberErrorCode;
import com.dteam.neordinarydteam.domain.member.service.query.MemberQueryService;
import com.dteam.neordinarydteam.global.apiPayload.code.ErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import com.dteam.neordinarydteam.global.swagger.annotation.ApiErrorCodeExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Member", description = "Member API")
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberQueryService memberQueryService;

    @Operation(summary = "회원 역할 조회 API", description = "회원의 UUID를 통해 해당 회원의 현재 역할을 조회합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            member = {MemberErrorCode.MEMBER_NOT_FOUND})
    @GetMapping("/{uuid}/role")
    public ApiResponse<MemberResponse.RoleDTO> getMemberRole(
            @Parameter(description = "회원의 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000")
                    @PathVariable
                    @NotNull(message = "UUID는 필수 값입니다.")
                    UUID uuid) {

        return ApiResponse.onSuccess(SuccessCode.OK, memberQueryService.getMemberRole(uuid));
    }

    @Operation(summary = "회원 정보 조회 API", description = "회원의 UUID를 통해 해당 회원의 정보(UUID, 역할, 닉네임)를 조회합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            member = {MemberErrorCode.MEMBER_NOT_FOUND})
    @GetMapping("/{uuid}")
    public ApiResponse<MemberResponse.InfoDTO> getMemberInfo(
            @Parameter(description = "회원의 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000")
                    @PathVariable
                    @NotNull(message = "UUID는 필수 값입니다.")
                    UUID uuid) {

        return ApiResponse.onSuccess(SuccessCode.OK, memberQueryService.getMemberInfo(uuid));
    }
}
