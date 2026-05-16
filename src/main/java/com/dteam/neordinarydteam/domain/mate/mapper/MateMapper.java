package com.dteam.neordinarydteam.domain.mate.mapper;

import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.mate.dto.request.MateRequest;
import com.dteam.neordinarydteam.domain.mate.dto.response.MateResponse;
import com.dteam.neordinarydteam.domain.mate.entity.Mate;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MateMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Mate toCreateEntity(Customer customer, Facility facility, MateRequest.CreateDTO dto);

    @Mapping(source = "mate.id", target = "mateId")
    @Mapping(source = "uuid", target = "uuid")
    @Mapping(source = "mate.createdAt", target = "createdAt")
    MateResponse.CreateDTO toCreateDTO(Mate mate, UUID uuid);

    @Mapping(source = "facility.id", target = "facilityId")
    @Mapping(source = "facility.region", target = "region")
    MateResponse.ListDTO toListDTO(Mate mate);
}
