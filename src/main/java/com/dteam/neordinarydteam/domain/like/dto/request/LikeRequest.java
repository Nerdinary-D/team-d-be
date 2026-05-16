package com.dteam.neordinarydteam.domain.like.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public final class LikeRequest {
    private LikeRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "LikeCreateRequest", description = "찜 생성 요청 객체")
    public record CreateDTO(
            @Schema(
                            description = "요청 고객의 회원 고유 UUID",
                            example = "123e4567-e89b-12d3-a456-426614174000",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotNull(message = "고객 UUID는 필수 입력 값입니다.")
                    UUID uuid,
            @Schema(description = "찜할 시설물 고유 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotNull(message = "시설물 ID는 필수 입력 값입니다.")
                    Long facilityId) {}
}
