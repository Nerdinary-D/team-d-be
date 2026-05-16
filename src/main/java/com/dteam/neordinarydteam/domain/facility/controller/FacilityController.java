package com.dteam.neordinarydteam.domain.facility.controller;

import com.dteam.neordinarydteam.domain.facility.dto.request.FacilityRequest;
import com.dteam.neordinarydteam.domain.facility.dto.response.FacilityResponse;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.facility.service.command.FacilityCommandService;
import com.dteam.neordinarydteam.domain.facility.service.query.FacilityQueryService;
import com.dteam.neordinarydteam.global.apiPayload.code.ErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import com.dteam.neordinarydteam.global.enums.Region;
import com.dteam.neordinarydteam.global.swagger.annotation.ApiErrorCodeExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "Facility", description = "시설 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/facilities")
public class FacilityController {

    private final FacilityCommandService facilityCommandService;
    private final FacilityQueryService facilityQueryService;

    @Operation(
            summary = "시설 등록",
            description = "사장님이 시설을 등록합니다.",
            requestBody =
                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                            content =
                                    @io.swagger.v3.oas.annotations.media.Content(
                                            mediaType = MediaType.MULTIPART_FORM_DATA_VALUE,
                                            encoding =
                                                    @io.swagger.v3.oas.annotations.media.Encoding(
                                                            name = "request",
                                                            contentType = MediaType.APPLICATION_JSON_VALUE))))
    @ApiErrorCodeExamples(
            value = {ErrorCode.INVALID_TYPE_VALUE},
            facility = {
                FacilityErrorCode.INVALID_UUID,
                FacilityErrorCode.MEMBER_NOT_FOUND,
                FacilityErrorCode.GEOCODING_FAILED,
                FacilityErrorCode.IMAGE_UPLOAD_FAILED
            })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<FacilityResponse.CreateDTO> createFacility(
            @Valid @RequestPart("request") FacilityRequest.CreateDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        FacilityResponse.CreateDTO response = facilityCommandService.createFacility(request, image);
        return ApiResponse.onSuccess(SuccessCode.CREATED, response);
    }

    @Operation(summary = "시설 상세 조회", description = "시설 상세 정보를 조회합니다.")
    @ApiErrorCodeExamples(facility = {FacilityErrorCode.FACILITY_NOT_FOUND})
    @GetMapping("/{facilityId}")
    public ApiResponse<FacilityResponse.DetailDTO> getFacility(@PathVariable Long facilityId) {
        FacilityResponse.DetailDTO response = facilityQueryService.getFacility(facilityId);
        return ApiResponse.onSuccess(SuccessCode.OK, response);
    }

    @Operation(summary = "맞춤형 시설 목록 조회", description = "사용자의 큐레이션 리스트와 시설의 큐레이션 리스트의 교집합 개수가 많은 순서대로 시설 목록을 반환합니다.")
    @ApiErrorCodeExamples(facility = {FacilityErrorCode.CUSTOMER_NOT_FOUND})
    @GetMapping("/recommended/{uuid}")
    public ApiResponse<PageResponse<FacilityResponse.ListItemDTO>> getRecommendedFacilities(
            @Parameter(description = "회원 UUID", example = "123e4567-e89b-12d3-a456-426614174000") @PathVariable
                    String uuid,
            @Parameter(description = "지역 필터 (미입력 시 전체)") @RequestParam(required = false) Region region,
            @ParameterObject @PageableDefault(size = 10) Pageable pageable) {
        PageResponse<FacilityResponse.ListItemDTO> response =
                facilityQueryService.getRecommendedFacilities(uuid, region, pageable);
        return ApiResponse.onSuccess(SuccessCode.OK, response);
    }
}
