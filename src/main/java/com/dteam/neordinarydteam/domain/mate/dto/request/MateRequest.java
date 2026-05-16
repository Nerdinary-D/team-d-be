package com.dteam.neordinarydteam.domain.mate.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public final class MateRequest {
    private MateRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "MateCreateRequest", description = "메이트 생성 요청 객체")
    public record CreateDTO(
            UUID uuid, Long facilityId, String title, String meetingTime, String content, String openchatLink) {}
}
