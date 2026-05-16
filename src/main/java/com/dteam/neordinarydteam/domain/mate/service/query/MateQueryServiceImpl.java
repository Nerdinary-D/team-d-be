package com.dteam.neordinarydteam.domain.mate.service.query;

import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.facility.exception.FacilityException;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.facility.repository.FacilityRepository;
import com.dteam.neordinarydteam.domain.mate.dto.response.MateResponse;
import com.dteam.neordinarydteam.domain.mate.entity.Mate;
import com.dteam.neordinarydteam.domain.mate.mapper.MateMapper;
import com.dteam.neordinarydteam.domain.mate.repository.MateRepository;
import com.dteam.neordinarydteam.global.apiPayload.converter.PageConverter;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MateQueryServiceImpl implements MateQueryService {
    private final MateRepository mateRepository;
    private final MateMapper mateMapper;
    private final FacilityRepository facilityRepository;

    @Override
    public PageResponse<MateResponse.ListDTO> getPosts(Long facilityId, Pageable pageable) {
        Page<Mate> matePage;

        if (facilityId == null) {
            // 조건 없이 전체를 페이징 조회
            matePage = mateRepository.findAll(pageable);
        } else {
            // Facility 존재 여부 검증 및 조건 조회
            Facility facility = facilityRepository
                    .findById(facilityId)
                    .orElseThrow(() -> new FacilityException(FacilityErrorCode.FACILITY_NOT_FOUND));

            matePage = mateRepository.findAllByFacility(facility, pageable);
        }

        // PageConverter를 통해 DTO 기반의 PageResponse로 변환 후 반환
        return PageConverter.toPageResponse(matePage, mateMapper::toListDTO);
    }
}
