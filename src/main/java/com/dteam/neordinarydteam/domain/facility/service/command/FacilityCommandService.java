package com.dteam.neordinarydteam.domain.facility.service.command;

import com.dteam.neordinarydteam.domain.facility.dto.request.FacilityRequest;
import com.dteam.neordinarydteam.domain.facility.dto.response.FacilityResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FacilityCommandService {
    FacilityResponse.CreateDTO createFacility(String uuid, FacilityRequest.CreateDTO request, MultipartFile image);
}
