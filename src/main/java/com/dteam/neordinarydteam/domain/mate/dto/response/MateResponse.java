package com.dteam.neordinarydteam.domain.mate.dto.response;

import com.dteam.neordinarydteam.global.enums.Region;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.UUID;

public final class MateResponse {
    private MateResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "MateCreateResponse", description = "메이트 생성 완료 응답 객체")
    public record CreateDTO(
            @Schema(description = "생성된 고객의 회원 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid,
            Long mateId,
            @Schema(description = "생성 일시") LocalDateTime createdAt) {}

    public record ListDTO(
            Long facilityId,
            Region region,
            String title,
            String meetingTime,
            String content,
            String openchatLink,
            LocalDateTime createdAt) {}
}
