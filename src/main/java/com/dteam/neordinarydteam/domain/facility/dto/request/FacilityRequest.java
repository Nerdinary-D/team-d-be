package com.dteam.neordinarydteam.domain.facility.dto.request;

import com.dteam.neordinarydteam.domain.facility.entity.Category;
import com.dteam.neordinarydteam.domain.facility.entity.InfraInfo;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public final class FacilityRequest {
    private FacilityRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO(
            @NotBlank String name,
            @NotBlank String roadAddress,
            String detailAddress,
            Category category,
            List<InfraInfo> infraInfos) {}
}
