package com.dteam.neordinarydteam.domain.like.dto.request;

import java.util.UUID;

public final class LikeRequest {
    private LikeRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO(UUID uuid, Long facilityId) {}
}
