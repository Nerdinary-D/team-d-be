package com.dteam.neordinarydteam.domain.customer.dto.request;

public final class CustomerRequest {
    private CustomerRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO() {}
}
