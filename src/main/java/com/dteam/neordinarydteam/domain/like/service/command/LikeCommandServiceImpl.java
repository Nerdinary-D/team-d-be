package com.dteam.neordinarydteam.domain.like.service.command;

import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.customer.exception.CustomerException;
import com.dteam.neordinarydteam.domain.customer.exception.code.CustomerErrorCode;
import com.dteam.neordinarydteam.domain.customer.repository.CustomerRepository;
import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.facility.exception.FacilityException;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.facility.repository.FacilityRepository;
import com.dteam.neordinarydteam.domain.like.dto.request.LikeRequest;
import com.dteam.neordinarydteam.domain.like.mapper.LikeMapper;
import com.dteam.neordinarydteam.domain.like.repository.LikeRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeCommandServiceImpl implements LikeCommandService {
    private final LikeRepository likeRepository;
    private final LikeMapper likeMapper;
    private final CustomerRepository customerRepository;
    private final FacilityRepository facilityRepository;

    @Override
    public void createLike(LikeRequest.CreateDTO dto) {
        Customer customer = customerRepository
                .findByUuid(dto.uuid())
                .orElseThrow(() -> new CustomerException(CustomerErrorCode.CUSTOMER_NOT_FOUND));

        Facility facility = facilityRepository
                .findById(dto.facilityId())
                .orElseThrow(() -> new FacilityException(FacilityErrorCode.FACILITY_NOT_FOUND));

        if (likeRepository.existsByCustomerIdAndFacilityId(customer.getId(), dto.facilityId())) {
            return;
        }

        likeRepository.save(likeMapper.toCreateEntity(customer, facility));
    }

    @Override
    public void deleteLike(UUID uuid, Long facilityId) {
        Customer customer = customerRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new CustomerException(CustomerErrorCode.CUSTOMER_NOT_FOUND));

        Facility facility = facilityRepository
                .findById(facilityId)
                .orElseThrow(() -> new FacilityException(FacilityErrorCode.FACILITY_NOT_FOUND));

        likeRepository
                .findByCustomerIdAndFacilityId(customer.getId(), facility.getId())
                .ifPresent(likeRepository::delete);
    }
}
