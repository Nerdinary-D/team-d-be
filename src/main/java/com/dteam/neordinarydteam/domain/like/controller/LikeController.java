package com.dteam.neordinarydteam.domain.like.controller;

import com.dteam.neordinarydteam.domain.like.dto.request.LikeRequest;
import com.dteam.neordinarydteam.domain.like.dto.response.LikeResponse;
import com.dteam.neordinarydteam.domain.like.service.command.LikeCommandService;
import com.dteam.neordinarydteam.domain.like.service.query.LikeQueryService;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

    @PostMapping
    public ApiResponse<Void> createLike(@Valid @RequestBody LikeRequest.CreateDTO dto) {
        likeCommandService.createLike(dto);
        return ApiResponse.onSuccess(SuccessCode.CREATED, null);
    }

    @DeleteMapping
    public ApiResponse<Void> deleteLike(@RequestParam UUID uuid, @RequestParam Long facilityId) {
        likeCommandService.deleteLike(uuid, facilityId);
        return ApiResponse.onSuccess(SuccessCode.OK, null);
    }

    @GetMapping
    public ApiResponse<LikeResponse.ExistDTO> getExistsLike(@RequestParam UUID uuid, @RequestParam Long facilityId) {
        return ApiResponse.onSuccess(SuccessCode.OK, likeQueryService.getExistsLike(uuid, facilityId));
    }

    @GetMapping("/me")
    public ApiResponse<PageResponse<LikeResponse.MyDTO>> getMyLikes(
            @RequestParam UUID uuid,
            @ParameterObject @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
                    Pageable pageable) {
        return ApiResponse.onSuccess(SuccessCode.OK, likeQueryService.getMyLikes(uuid, pageable));
    }
}
