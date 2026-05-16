package com.dteam.neordinarydteam.domain.like.service.query;

import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.customer.exception.CustomerException;
import com.dteam.neordinarydteam.domain.customer.exception.code.CustomerErrorCode;
import com.dteam.neordinarydteam.domain.customer.repository.CustomerRepository;
import com.dteam.neordinarydteam.domain.facility.repository.FacilityRepository;
import com.dteam.neordinarydteam.domain.like.dto.response.LikeResponse;
import com.dteam.neordinarydteam.domain.like.entity.Like;
import com.dteam.neordinarydteam.domain.like.mapper.LikeMapper;
import com.dteam.neordinarydteam.domain.like.repository.LikeRepository;
import com.dteam.neordinarydteam.global.apiPayload.converter.PageConverter;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeQueryServiceImpl implements LikeQueryService {
    private final LikeRepository likeRepository;
    private final LikeMapper likeMapper;
    private final CustomerRepository customerRepository;
    private final FacilityRepository facilityRepository;

    @Override
    public LikeResponse.ExistDTO getExistsLike(UUID uuid, Long facilityId) {
        Customer customer = customerRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new CustomerException(CustomerErrorCode.CUSTOMER_NOT_FOUND));

        if (likeRepository.existsByCustomerIdAndFacilityId(customer.getId(), facilityId)) {
            return likeMapper.toExistDTO(uuid, true);
        }
        return likeMapper.toExistDTO(uuid, false);
    }

    @Override
    public PageResponse<LikeResponse.MyDTO> getMyLikes(UUID uuid, Pageable pageable) {
        // 요청 유저(Customer) 검증 및 조회
        Customer customer = customerRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new CustomerException(CustomerErrorCode.CUSTOMER_NOT_FOUND));

        // Fetch Join이 적용된 레포지토리 메서드 호출 (N+1 방지)
        Page<Like> likePage = likeRepository.findByCustomerIdWithFacility(customer.getId(), pageable);

        return PageConverter.toPageResponse(likePage, like -> likeMapper.toMyDTO(like, uuid));
    }
}
