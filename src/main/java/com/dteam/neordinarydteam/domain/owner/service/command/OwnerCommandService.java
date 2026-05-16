package com.dteam.neordinarydteam.domain.owner.service.command;

import com.dteam.neordinarydteam.domain.owner.dto.request.OwnerRequest;
import com.dteam.neordinarydteam.domain.owner.dto.response.OwnerResponse;

public interface OwnerCommandService {
    OwnerResponse.CreateDTO createOwner(OwnerRequest.CreateDTO dto);
}
