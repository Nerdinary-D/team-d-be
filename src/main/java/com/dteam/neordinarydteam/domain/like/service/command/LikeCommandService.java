package com.dteam.neordinarydteam.domain.like.service.command;

import com.dteam.neordinarydteam.domain.like.dto.request.LikeRequest;
import java.util.UUID;

public interface LikeCommandService {

    void createLike(LikeRequest.CreateDTO dto);

    void deleteLike(UUID uuid, Long facilityId);
}
