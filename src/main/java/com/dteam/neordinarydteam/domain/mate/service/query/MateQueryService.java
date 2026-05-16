package com.dteam.neordinarydteam.domain.mate.service.query;

import com.dteam.neordinarydteam.domain.mate.dto.response.MateResponse;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import org.springframework.data.domain.Pageable;

public interface MateQueryService {
    PageResponse<MateResponse.ListDTO> getPosts(Long facilityId, Pageable pageable);
}
