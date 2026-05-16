package com.dteam.neordinarydteam.domain.mate.controller;

import com.dteam.neordinarydteam.domain.customer.exception.code.CustomerErrorCode;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.mate.dto.request.MateRequest;
import com.dteam.neordinarydteam.domain.mate.dto.response.MateResponse;
import com.dteam.neordinarydteam.domain.mate.service.command.MateCommandService;
import com.dteam.neordinarydteam.domain.mate.service.query.MateQueryService;
import com.dteam.neordinarydteam.global.apiPayload.code.ErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import com.dteam.neordinarydteam.global.swagger.annotation.ApiErrorCodeExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Mate", description = "Mate API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mates")
public class MateController {
    private final MateQueryService mateQueryService;
    private final MateCommandService mateCommandService;

    @Operation(summary = "메이트 모집글 작성 API", description = "시설물 정보 및 본문 내용을 입력받아 새로운 메이트 구인 글을 게시합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            customer = {CustomerErrorCode.CUSTOMER_NOT_FOUND},
            facility = {FacilityErrorCode.FACILITY_NOT_FOUND})
    @PostMapping
    public ApiResponse<MateResponse.CreateDTO> createPost(@Valid @RequestBody MateRequest.CreateDTO dto) {
        return ApiResponse.onSuccess(SuccessCode.CREATED, mateCommandService.createPost(dto));
    }

    @Operation(summary = "메이트 모집글 목록 페이징 조회 API", description = "특정 시설물 ID 필터링 혹은 전체 모집글 리스트를 최신순으로 페이징 조회합니다.")
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            facility = {FacilityErrorCode.FACILITY_NOT_FOUND})
    @GetMapping
    public ApiResponse<PageResponse<MateResponse.ListDTO>> getPosts(
            @Parameter(description = "필터링할 시설물 고유 ID (생략 시 전체 조회)", example = "1") @RequestParam(required = false)
                    Long facilityId,
            @ParameterObject @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
                    Pageable pageable) {
        return ApiResponse.onSuccess(SuccessCode.OK, mateQueryService.getPosts(facilityId, pageable));
    }
}
