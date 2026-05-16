package com.dteam.neordinarydteam.domain.customer.service.command;

import com.dteam.neordinarydteam.domain.customer.dto.request.CustomerRequest;
import com.dteam.neordinarydteam.domain.customer.dto.response.CustomerResponse;
import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.customer.exception.CustomerException;
import com.dteam.neordinarydteam.domain.customer.exception.code.CustomerErrorCode;
import com.dteam.neordinarydteam.domain.customer.mapper.CustomerMapper;
import com.dteam.neordinarydteam.domain.customer.repository.CustomerRepository;
import com.dteam.neordinarydteam.domain.member.entity.Member;
import com.dteam.neordinarydteam.domain.member.enums.MemberRole;
import com.dteam.neordinarydteam.domain.member.mapper.MemberMapper;
import com.dteam.neordinarydteam.domain.member.repository.MemberRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerCommandServiceImpl implements CustomerCommandService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    @Override
    public CustomerResponse.CreateDTO createCustomer(CustomerRequest.CreateDTO dto) {
        Member savedMember = memberRepository.save(memberMapper.toCreateEntity(dto.uuid(), MemberRole.ROLE_CUSTOMER));

        Customer savedCustomer = customerRepository.save(customerMapper.toCreateEntity(dto, savedMember));

        return customerMapper.toCreateDTO(savedMember.getUuid(), savedCustomer);
    }

    @Override
    public CustomerResponse.UpdateDTO updateCustomer(UUID uuid, CustomerRequest.UpdateDTO dto) {
        Customer customer = customerRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new CustomerException(CustomerErrorCode.CUSTOMER_NOT_FOUND));

        customer.update(dto.curation(), dto.region());

        return customerMapper.toUpdateDTO(customer);
    }

    @Override
    public CustomerResponse.DeleteDTO deleteCustomer(UUID uuid) {
        Customer customer = customerRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new CustomerException(CustomerErrorCode.CUSTOMER_NOT_FOUND));

        customerRepository.delete(customer);
        return customerMapper.toDeleteDTO(uuid, LocalDateTime.now());
    }
}
