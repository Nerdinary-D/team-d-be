package com.dteam.neordinarydteam.domain.facility.mapper;

import com.dteam.neordinarydteam.domain.facility.dto.response.FacilityResponse;
import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FacilityMapper {

    FacilityResponse.DetailDTO toDetailDTO(Facility facility);
}
