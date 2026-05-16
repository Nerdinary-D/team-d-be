package com.dteam.neordinarydteam.domain.facility.service.query;

import com.dteam.neordinarydteam.domain.facility.dto.response.FacilityResponse;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import com.dteam.neordinarydteam.global.enums.Region;
import org.springframework.data.domain.Pageable;

public interface FacilityQueryService {
    FacilityResponse.DetailDTO getFacility(Long facilityId);

    PageResponse<FacilityResponse.ListItemDTO> getRecommendedFacilities(String uuid, Region region, Pageable pageable);
}
