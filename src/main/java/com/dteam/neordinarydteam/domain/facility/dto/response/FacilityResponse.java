package com.dteam.neordinarydteam.domain.facility.dto.response;

import com.dteam.neordinarydteam.domain.facility.entity.Category;
import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public final class FacilityResponse {
    private FacilityResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "FacilityCreateResponse", description = "시설 생성 응답 객체")
    public record CreateDTO(
            @Schema(description = "생성된 시설 고유 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
                    Long facilityId) {}

    @Schema(description = "시설 상세 정보 조회 응답 객체")
    public record DetailDTO(
            @Schema(description = "시설 고유 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED) Long id,
            @Schema(description = "시설 명칭", example = "해피 배드민턴장", requiredMode = Schema.RequiredMode.REQUIRED)
                    String name,
            @Schema(description = "시설 업종 카테고리", example = "BADMINTON", requiredMode = Schema.RequiredMode.REQUIRED)
                    Category category,
            @Schema(description = "시설 대표 이미지 S3 URL", example = "https://s3.amazonaws.com/bucket/facility/1.png")
                    String image,
            @Schema(description = "시설 소속 광역 지역 식별자", example = "SEOUL", requiredMode = Schema.RequiredMode.REQUIRED)
                    Region region,
            @Schema(
                            description = "시설에 설정된 맞춤형 큐레이션 리스트",
                            example = "[\"NO_STEP_COURT_ENTRY\", \"SPORTS_WHEELCHAIR_RENTAL\"]")
                    List<Curation> curations,
            @Schema(description = "시설 상세 주소 및 좌표 정보 객체", requiredMode = Schema.RequiredMode.REQUIRED)
                    AddressDTO address) {}

    @Schema(description = "추천/일반 시설 목록 조회용 단일 항목 DTO")
    public record ListItemDTO(
            @Schema(description = "시설 고유 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED) Long id,
            @Schema(description = "시설 명칭", example = "해피 배드민턴장", requiredMode = Schema.RequiredMode.REQUIRED)
                    String name,
            @Schema(description = "시설 업종 카테고리", example = "BADMINTON", requiredMode = Schema.RequiredMode.REQUIRED)
                    Category category,
            @Schema(description = "시설 대표 이미지 S3 URL", example = "https://s3.amazonaws.com/bucket/facility/1.png")
                    String image,
            @Schema(description = "시설 소속 광역 지역 식별자", example = "SEOUL", requiredMode = Schema.RequiredMode.REQUIRED)
                    Region region,
            @Schema(description = "시설에 설정된 맞춤형 큐레이션 리스트", example = "[\"NO_STEP_COURT_ENTRY\"]")
                    List<Curation> curations,
            @Schema(
                            description = "유저 프로필과의 큐레이션 교집합 일치 개수 (Owner인 경우 0 고정)",
                            example = "3",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    int matchCount,
            @Schema(
                            description = "요청 유저의 해당 시설 찜(좋아요) 여부",
                            example = "true",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    boolean isLiked) {}

    @Schema(description = "시설 주소 및 정밀 좌표 명세 객체")
    public record AddressDTO(
            @Schema(description = "시/도", example = "서울특별시", requiredMode = Schema.RequiredMode.REQUIRED) String sido,
            @Schema(description = "시/군/구", example = "강남구", requiredMode = Schema.RequiredMode.REQUIRED) String sigungu,
            @Schema(
                            description = "도로명 주소 기본형",
                            example = "서울특별시 강남구 테헤란로 123",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    String roadAddress,
            @Schema(description = "상세 주소 (건물명, 호수 등)", example = "2층 201호") String detailAddress,
            @Schema(
                            description = "위도 좌표 (정밀도 유지를 위해 String 처리)",
                            example = "37.5665",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    String latitude,
            @Schema(
                            description = "경도 좌표 (정밀도 유지를 위해 String 처리)",
                            example = "126.9780",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    String longitude) {}
}
