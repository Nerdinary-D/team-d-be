package com.dteam.neordinarydteam.domain.owner.controller;

import com.dteam.neordinarydteam.domain.owner.dto.request.OwnerRequest;
import com.dteam.neordinarydteam.domain.owner.dto.response.OwnerResponse;
import com.dteam.neordinarydteam.domain.owner.service.command.OwnerCommandService;
import com.dteam.neordinarydteam.global.apiPayload.code.ErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import com.dteam.neordinarydteam.global.swagger.annotation.ApiErrorCodeExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Owner", description = "Owner API")
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/owners")
public class OwnerController {
    private final OwnerCommandService ownerCommandService;

    @Operation(summary = "사장 생성 API", description = "새로운 사장 정보를 생성하고 Member 권한을 부여합니다.")
    @ApiErrorCodeExamples(value = {ErrorCode.INVALID_TYPE_VALUE})
    @PostMapping
    public ApiResponse<OwnerResponse.CreateDTO> createOwner(@Valid @RequestBody OwnerRequest.CreateDTO dto) {
        return ApiResponse.onSuccess(SuccessCode.CREATED, ownerCommandService.createOwner(dto));
    }
}
