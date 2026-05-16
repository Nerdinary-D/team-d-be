package com.dteam.neordinarydteam.domain.facility.dto.response;

import com.dteam.neordinarydteam.domain.facility.entity.Category;
import com.dteam.neordinarydteam.domain.facility.entity.InfraInfo;
import java.util.List;

public final class FacilityResponse {
    private FacilityResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record CreateDTO(Long facilityId) {}

    public record DetailDTO(
            Long id, String name, Category category, String image, List<InfraInfo> infraInfos, AddressDTO address) {}

    public record AddressDTO(
            String sido, String sigungu, String roadAddress, String detailAddress, String latitude, String longitude) {}
}
