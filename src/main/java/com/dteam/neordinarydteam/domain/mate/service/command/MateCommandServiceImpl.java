package com.dteam.neordinarydteam.domain.mate.service.command;

import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.customer.exception.CustomerException;
import com.dteam.neordinarydteam.domain.customer.exception.code.CustomerErrorCode;
import com.dteam.neordinarydteam.domain.customer.repository.CustomerRepository;
import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.facility.exception.FacilityException;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.facility.repository.FacilityRepository;
import com.dteam.neordinarydteam.domain.mate.dto.request.MateRequest;
import com.dteam.neordinarydteam.domain.mate.dto.response.MateResponse;
import com.dteam.neordinarydteam.domain.mate.entity.Mate;
import com.dteam.neordinarydteam.domain.mate.mapper.MateMapper;
import com.dteam.neordinarydteam.domain.mate.repository.MateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MateCommandServiceImpl implements MateCommandService {
    private final MateRepository mateRepository;
    private final MateMapper mateMapper;
    private final CustomerRepository customerRepository;
    private final FacilityRepository facilityRepository;

    @Override
    public MateResponse.CreateDTO createPost(MateRequest.CreateDTO dto) {
        Customer customer = customerRepository
                .findByUuid(dto.uuid())
                .orElseThrow(() -> new CustomerException(CustomerErrorCode.CUSTOMER_NOT_FOUND));

        Facility facility = facilityRepository
                .findById(dto.facilityId())
                .orElseThrow(() -> new FacilityException(FacilityErrorCode.FACILITY_NOT_FOUND));

        Mate savedMate = mateRepository.save(mateMapper.toCreateEntity(customer, facility, dto));
        return mateMapper.toCreateDTO(savedMate, dto.uuid());
    }
}
