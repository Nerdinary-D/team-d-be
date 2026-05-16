package com.dteam.neordinarydteam.domain.customer.dto.response;

import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import java.time.LocalDateTime;
import java.util.UUID;

public final class CustomerResponse {
    private CustomerResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO(UUID uuid, LocalDateTime createdAt) {}

    public record UpdateDTO(UUID uuid, LocalDateTime updatedAt) {}

    public record DeleteDTO(UUID uuid, LocalDateTime deletedAt) {}

    public record MyProfileDTO(UUID uuid, Curation curation, Region region, LocalDateTime createdAt) {}
}
