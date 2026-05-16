package com.dteam.neordinarydteam.domain.owner.dto.request;

public final class OwnerRequest {
    private OwnerRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO() {}
}
