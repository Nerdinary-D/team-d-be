package com.dteam.neordinarydteam.domain.member.mapper;

import com.dteam.neordinarydteam.domain.member.dto.response.MemberResponse;
import com.dteam.neordinarydteam.domain.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    MemberResponse.RoleDTO toRoleDTO(Member member);
}
