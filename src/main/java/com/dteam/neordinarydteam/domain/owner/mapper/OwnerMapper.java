package com.dteam.neordinarydteam.domain.owner.mapper;

import com.dteam.neordinarydteam.domain.member.entity.Member;
import com.dteam.neordinarydteam.domain.owner.dto.response.OwnerResponse;
import com.dteam.neordinarydteam.domain.owner.entity.Owner;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OwnerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "memberId", source = "member.id")
    @Mapping(target = "facilityId", ignore = true)
    Owner toCreateEntity(Member member);

    @Mapping(source = "owner.createdAt", target = "createdAt")
    OwnerResponse.CreateDTO toCreateDTO(UUID uuid, Owner owner);
}
