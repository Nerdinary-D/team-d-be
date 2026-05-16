package com.dteam.neordinarydteam.domain.member.dto.request;

public final class MemberRequest {
    private MemberRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO() {}
}
