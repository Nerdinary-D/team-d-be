package com.dteam.neordinarydteam.domain.facility.service.query;

import com.dteam.neordinarydteam.domain.address.entity.Address;
import com.dteam.neordinarydteam.domain.address.repository.AddressRepository;
import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.customer.repository.CustomerRepository;
import com.dteam.neordinarydteam.domain.facility.dto.response.FacilityResponse;
import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.facility.exception.FacilityException;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.facility.repository.FacilityRepository;
import com.dteam.neordinarydteam.global.apiPayload.converter.PageConverter;
import com.dteam.neordinarydteam.global.apiPayload.response.PageResponse;
import com.dteam.neordinarydteam.global.enums.Curation;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FacilityQueryServiceImpl implements FacilityQueryService {

    private final FacilityRepository facilityRepository;
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

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
                facility.getRegion(),
                facility.getCurations(),
                addressDTO);
    }

    @Override
    public PageResponse<FacilityResponse.ListItemDTO> getRecommendedFacilities(String uuid, Pageable pageable) {
        Customer customer = customerRepository
                .findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new FacilityException(FacilityErrorCode.CUSTOMER_NOT_FOUND));

        Set<Curation> customerCurations = Set.copyOf(customer.getCurations());

        List<FacilityResponse.ListItemDTO> allItems = facilityRepository.findAll().stream()
                .map(facility -> {
                    int matchCount = (int) facility.getCurations().stream()
                            .filter(customerCurations::contains)
                            .count();
                    return new FacilityResponse.ListItemDTO(
                            facility.getId(),
                            facility.getName(),
                            facility.getCategory(),
                            facility.getImage(),
                            facility.getRegion(),
                            facility.getCurations(),
                            matchCount);
                })
                .sorted(Comparator.comparingInt(FacilityResponse.ListItemDTO::matchCount)
                        .reversed())
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), allItems.size());
        List<FacilityResponse.ListItemDTO> pageContent =
                start >= allItems.size() ? List.of() : allItems.subList(start, end);

        Page<FacilityResponse.ListItemDTO> page = new PageImpl<>(pageContent, pageable, allItems.size());
        return PageConverter.toPageResponse(page);
    }
}
