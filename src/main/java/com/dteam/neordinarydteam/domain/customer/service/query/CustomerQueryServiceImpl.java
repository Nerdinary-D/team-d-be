package com.dteam.neordinarydteam.domain.customer.service.query;

import com.dteam.neordinarydteam.domain.customer.dto.response.CustomerResponse;
import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.customer.exception.CustomerException;
import com.dteam.neordinarydteam.domain.customer.exception.code.CustomerErrorCode;
import com.dteam.neordinarydteam.domain.customer.mapper.CustomerMapper;
import com.dteam.neordinarydteam.domain.customer.repository.CustomerRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerQueryServiceImpl implements CustomerQueryService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse.MyProfileDTO getMyProfile(UUID uuid) {
        Customer customer = customerRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new CustomerException(CustomerErrorCode.CUSTOMER_NOT_FOUND));

        return customerMapper.toMyProfileDTO(customer);
    }
}
