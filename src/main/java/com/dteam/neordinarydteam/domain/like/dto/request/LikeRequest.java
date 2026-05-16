package com.dteam.neordinarydteam.domain.like.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public final class LikeRequest {
    private LikeRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "LikeCreateRequest", description = "찜 생성 요청 객체")
    public record CreateDTO(UUID uuid, Long facilityId) {}
}
