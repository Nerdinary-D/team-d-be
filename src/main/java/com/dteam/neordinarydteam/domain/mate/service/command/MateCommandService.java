package com.dteam.neordinarydteam.domain.mate.service.command;

import com.dteam.neordinarydteam.domain.mate.dto.request.MateRequest;
import com.dteam.neordinarydteam.domain.mate.dto.response.MateResponse;

public interface MateCommandService {
    MateResponse.CreateDTO createPost(MateRequest.CreateDTO dto);
}
