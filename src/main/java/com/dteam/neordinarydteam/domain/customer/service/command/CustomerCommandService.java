package com.dteam.neordinarydteam.domain.customer.service.command;

import com.dteam.neordinarydteam.domain.customer.dto.request.CustomerRequest;
import com.dteam.neordinarydteam.domain.customer.dto.response.CustomerResponse;
import java.util.UUID;

public interface CustomerCommandService {
    CustomerResponse.CreateDTO createCustomer(CustomerRequest.CreateDTO dto);

    CustomerResponse.UpdateDTO updateCustomer(UUID uuid, CustomerRequest.UpdateDTO dto);

    CustomerResponse.DeleteDTO deleteCustomer(UUID uuid);
}
