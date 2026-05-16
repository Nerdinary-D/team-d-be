package com.dteam.neordinarydteam.domain.like.mapper;

import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.like.dto.response.LikeResponse;
import com.dteam.neordinarydteam.domain.like.entity.Like;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LikeMapper {
    Like toCreateEntity(Customer customer, Facility facility);

    LikeResponse.ExistDTO toExistDTO(UUID uuid, boolean isLiked);
}
