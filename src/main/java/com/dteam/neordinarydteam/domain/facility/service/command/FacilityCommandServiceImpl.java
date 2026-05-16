package com.dteam.neordinarydteam.domain.facility.service.command;

import com.dteam.neordinarydteam.domain.address.entity.Address;
import com.dteam.neordinarydteam.domain.address.repository.AddressRepository;
import com.dteam.neordinarydteam.domain.facility.dto.request.FacilityRequest;
import com.dteam.neordinarydteam.domain.facility.dto.response.FacilityResponse;
import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.facility.exception.FacilityException;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.facility.repository.FacilityRepository;
import com.dteam.neordinarydteam.domain.member.entity.Member;
import com.dteam.neordinarydteam.domain.member.repository.MemberRepository;
import com.dteam.neordinarydteam.domain.owner.entity.Owner;
import com.dteam.neordinarydteam.domain.owner.repository.OwnerRepository;
import com.dteam.neordinarydteam.global.util.KakaoGeocodingService;
import com.dteam.neordinarydteam.global.util.KakaoGeocodingService.KakaoAddressResult;
import com.dteam.neordinarydteam.global.util.S3Service;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class FacilityCommandServiceImpl implements FacilityCommandService {

    private final FacilityRepository facilityRepository;
    private final AddressRepository addressRepository;
    private final MemberRepository memberRepository;
    private final OwnerRepository ownerRepository;
    private final S3Service s3Service;
    private final KakaoGeocodingService kakaoGeocodingService;

    @Override
    public FacilityResponse.CreateDTO createFacility(
            String uuid, FacilityRequest.CreateDTO request, MultipartFile image) {
        Member member = memberRepository
                .findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new FacilityException(FacilityErrorCode.MEMBER_NOT_FOUND));

        // 카카오 API로 주소 정보 + 좌표 조회
        KakaoAddressResult addressResult = kakaoGeocodingService.getAddressInfo(request.roadAddress());

        // Address 저장
        Address address = Address.builder()
                .sido(addressResult.sido())
                .sigungu(addressResult.sigungu())
                .roadAddress(addressResult.roadAddress())
                .detailAddress(request.detailAddress())
                .latitude(addressResult.latitude())
                .longitude(addressResult.longitude())
                .build();

        Address savedAddress = addressRepository.save(address);

        // S3 이미지 업로드
        String imageUrl = s3Service.uploadFile(image);

        // Facility 저장
        Facility facility = Facility.builder()
                .name(request.name())
                .addressId(savedAddress.getId())
                .category(request.category())
                .image(imageUrl)
                .infraInfos(request.infraInfos())
                .build();

        Facility savedFacility = facilityRepository.save(facility);

        // Owner 저장
        Owner owner = Owner.builder()
                .memberId(member.getId())
                .facilityId(savedFacility.getId())
                .build();

        ownerRepository.save(owner);

        return new FacilityResponse.CreateDTO(savedFacility.getId());
    }
}
