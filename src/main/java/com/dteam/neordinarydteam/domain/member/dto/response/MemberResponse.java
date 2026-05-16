package com.dteam.neordinarydteam.domain.member.dto.response;

import com.dteam.neordinarydteam.domain.member.enums.MemberRole;
import io.swagger.v3.oas.annotations.media.Schema;

public final class MemberResponse {
    private MemberResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(description = "회원 역할 조회 응답 DTO")
    public record RoleDTO(
            @Schema(description = "회원의 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000") String uuid,
            @Schema(description = "회원의 권한/역할", example = "USER") MemberRole role) {}
}
