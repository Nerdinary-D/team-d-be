package com.dteam.neordinarydteam.domain.member.dto.response;

public final class MemberResponse {
    private MemberResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO() {}
}
