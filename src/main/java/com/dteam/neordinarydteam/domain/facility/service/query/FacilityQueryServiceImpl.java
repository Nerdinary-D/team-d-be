package com.dteam.neordinarydteam.domain.facility.service.query;

import com.dteam.neordinarydteam.domain.address.entity.Address;
import com.dteam.neordinarydteam.domain.address.repository.AddressRepository;
import com.dteam.neordinarydteam.domain.facility.dto.response.FacilityResponse;
import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.facility.exception.FacilityException;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.facility.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FacilityQueryServiceImpl implements FacilityQueryService {

    private final FacilityRepository facilityRepository;
    private final AddressRepository addressRepository;

    @Override
    public FacilityResponse.DetailDTO getFacility(Long facilityId) {
        Facility facility = facilityRepository
                .findById(facilityId)
                .orElseThrow(() -> new FacilityException(FacilityErrorCode.FACILITY_NOT_FOUND));

        Address address = addressRepository
                .findById(facility.getAddressId())
                .orElseThrow(() -> new FacilityException(FacilityErrorCode.FACILITY_NOT_FOUND));

        FacilityResponse.AddressDTO addressDTO = new FacilityResponse.AddressDTO(
                address.getSido(),
                address.getSigungu(),
                address.getRoadAddress(),
                address.getDetailAddress(),
                address.getLatitude(),
                address.getLongitude());

        return new FacilityResponse.DetailDTO(
                facility.getId(),
                facility.getName(),
                facility.getCategory(),
                facility.getImage(),
                facility.getInfraInfos(),
                addressDTO);
    }
}
