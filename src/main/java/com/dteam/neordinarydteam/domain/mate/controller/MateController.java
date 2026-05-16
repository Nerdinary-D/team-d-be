package com.dteam.neordinarydteam.domain.mate.controller;

import com.dteam.neordinarydteam.domain.mate.dto.request.MateRequest;
import com.dteam.neordinarydteam.domain.mate.dto.response.MateResponse;
import com.dteam.neordinarydteam.domain.mate.service.command.MateCommandService;
import com.dteam.neordinarydteam.domain.mate.service.query.MateQueryService;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
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

    @PostMapping
    public ApiResponse<MateResponse.CreateDTO> createPost(@Valid @RequestBody MateRequest.CreateDTO dto) {
        return ApiResponse.onSuccess(SuccessCode.CREATED, mateCommandService.createPost(dto));
    }

    @GetMapping
    public ApiResponse<PageResponse<MateResponse.ListDTO>> getPosts(
            @RequestParam Long facilityId,
            @ParameterObject @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
                    Pageable pageable) {
        return ApiResponse.onSuccess(SuccessCode.OK, mateQueryService.getPosts(facilityId, pageable));
    }
}
