package com.dteam.neordinarydteam.domain.facility.service.query;

import com.dteam.neordinarydteam.domain.facility.dto.response.FacilityResponse;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import org.springframework.data.domain.Pageable;

public interface FacilityQueryService {
    FacilityResponse.DetailDTO getFacility(Long facilityId);

    PageResponse<FacilityResponse.ListItemDTO> getRecommendedFacilities(String uuid, Pageable pageable);
}
