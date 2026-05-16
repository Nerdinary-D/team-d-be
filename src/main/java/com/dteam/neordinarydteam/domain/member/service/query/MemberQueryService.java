package com.dteam.neordinarydteam.domain.member.service.query;

import com.dteam.neordinarydteam.domain.member.dto.response.MemberResponse;
import java.util.UUID;

public interface MemberQueryService {
    MemberResponse.RoleDTO getMemberRole(UUID uuid);
}
