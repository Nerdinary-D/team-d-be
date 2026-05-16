package com.dteam.neordinarydteam.domain.member.service.query;

import com.dteam.neordinarydteam.domain.member.dto.response.MemberResponse;

public interface MemberQueryService {
    MemberResponse.RoleDTO getMemberRole(String uuid);
}
