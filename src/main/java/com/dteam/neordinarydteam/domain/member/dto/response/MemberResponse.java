package com.dteam.neordinarydteam.domain.member.dto.response;

import com.dteam.neordinarydteam.domain.member.enums.MemberRole;

public final class MemberResponse {
    private MemberResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record RoleDTO(String uuid, MemberRole role) {}
}
