package com.dteam.neordinarydteam.domain.customer.service.query;

import com.dteam.neordinarydteam.domain.customer.dto.response.CustomerResponse;
import java.util.UUID;

public interface CustomerQueryService {

    CustomerResponse.MyProfileDTO getMyProfile(UUID uuid);
}
