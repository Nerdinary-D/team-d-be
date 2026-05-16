package com.dteam.neordinarydteam.domain.customer.mapper;

import com.dteam.neordinarydteam.domain.customer.dto.request.CustomerRequest;
import com.dteam.neordinarydteam.domain.customer.dto.response.CustomerResponse;
import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.member.entity.Member;
import java.time.LocalDateTime;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "member", source = "member")
    Customer toCreateEntity(CustomerRequest.CreateDTO dto, Member member);

    @Mapping(source = "customer.createdAt", target = "createdAt")
    CustomerResponse.CreateDTO toCreateDTO(UUID uuid, Customer customer);

    @Mapping(source = "customer.member.uuid", target = "uuid")
    CustomerResponse.UpdateCurationsDTO toUpdateCurationsDTO(Customer customer);

    @Mapping(source = "customer.member.uuid", target = "uuid")
    CustomerResponse.UpdateRegionDTO toUpdateRegionDTO(Customer customer);

    CustomerResponse.DeleteDTO toDeleteDTO(UUID uuid, LocalDateTime deletedAt);

    @Mapping(source = "customer.member.uuid", target = "uuid")
    CustomerResponse.MyProfileDTO toMyProfileDTO(Customer customer);
}
