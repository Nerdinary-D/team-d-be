package com.dteam.neordinarydteam.domain.owner.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "사장 관련 응답 DTO 컨테이너")
public final class OwnerResponse {
    private OwnerResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(description = "사장 생성 완료 응답 객체")
    public record CreateDTO(
            @Schema(description = "생성된 사장의 회원 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid,
            @Schema(description = "생성 일시") LocalDateTime createdAt) {}
}
