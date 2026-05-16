package com.dteam.neordinarydteam.domain.facility.dto.request;

import com.dteam.neordinarydteam.domain.facility.entity.Category;
import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public final class FacilityRequest {
    private FacilityRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "FacilityCreateRequest", description = "시설 생성 요청 객체")
    public record CreateDTO(
            @NotBlank String name,
            @NotBlank String roadAddress,
            String detailAddress,
            Category category,
            Region region,
            List<Curation> curations) {}
}
