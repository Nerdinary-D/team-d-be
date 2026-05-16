package com.dteam.neordinarydteam.domain.customer.service.command;

import com.dteam.neordinarydteam.domain.customer.dto.request.CustomerRequest;
import com.dteam.neordinarydteam.domain.customer.dto.response.CustomerResponse;
import java.util.UUID;

public interface CustomerCommandService {
    CustomerResponse.CreateDTO createCustomer(CustomerRequest.CreateDTO dto);

    CustomerResponse.UpdateCurationsDTO updateCustomerCurations(UUID uuid, CustomerRequest.UpdateCurationsDTO dto);

    CustomerResponse.UpdateRegionDTO updateCustomerRegion(UUID uuid, CustomerRequest.UpdateRegionDTO dto);

    CustomerResponse.DeleteDTO deleteCustomer(UUID uuid);
}
