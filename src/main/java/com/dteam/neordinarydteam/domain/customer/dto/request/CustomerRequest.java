package com.dteam.neordinarydteam.domain.customer.dto.request;

import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import java.util.UUID;

public final class CustomerRequest {
    private CustomerRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO(UUID uuid, Curation curation, Region region) {}

    public record UpdateDTO(Curation curation, Region region) {}
}
