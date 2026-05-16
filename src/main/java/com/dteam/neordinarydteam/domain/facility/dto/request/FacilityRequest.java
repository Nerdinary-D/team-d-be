package com.dteam.neordinarydteam.domain.facility.dto.request;

public final class FacilityRequest {
    private FacilityRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO() {}
}
