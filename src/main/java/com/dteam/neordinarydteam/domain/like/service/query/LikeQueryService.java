package com.dteam.neordinarydteam.domain.like.service.query;

import com.dteam.neordinarydteam.domain.like.dto.response.LikeResponse;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import java.util.UUID;
import org.springframework.data.domain.Pageable;

public interface LikeQueryService {

    LikeResponse.ExistDTO getExistsLike(UUID uuid, Long facilityId);

    PageResponse<LikeResponse.MyDTO> getMyLikes(UUID uuid, Pageable pageable);
}
