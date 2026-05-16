package com.dteam.neordinarydteam.domain.example.dto.request;

public final class ExampleRequest {
    private ExampleRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO() {}
}
