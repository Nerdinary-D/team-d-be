package com.dteam.neordinarydteam.domain.facility.service.query;

import com.dteam.neordinarydteam.domain.facility.dto.response.FacilityResponse;

public interface FacilityQueryService {
    FacilityResponse.DetailDTO getFacility(Long facilityId);
}
