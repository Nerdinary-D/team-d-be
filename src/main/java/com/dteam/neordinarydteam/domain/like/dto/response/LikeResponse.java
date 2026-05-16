package com.dteam.neordinarydteam.domain.like.dto.response;

import com.dteam.neordinarydteam.domain.facility.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public final class LikeResponse {
    private LikeResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "LikeCreateResponse", description = "찜 생성 응답 객체")
    public record CreateDTO(UUID uuid) {}

    public record ExistDTO(UUID uuid, boolean isLiked) {}

    public record MyDTO(
            UUID uuid, String image, String name, Category category, List<String> hashTags, boolean isLiked) {}
}
