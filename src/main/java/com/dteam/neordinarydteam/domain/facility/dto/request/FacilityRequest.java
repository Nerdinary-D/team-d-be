package com.dteam.neordinarydteam.domain.facility.dto.request;

import com.dteam.neordinarydteam.domain.facility.entity.Category;
import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public final class FacilityRequest {
    private FacilityRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "FacilityCreateRequest", description = "시설 생성 요청 객체")
    public record CreateDTO(
            @Schema(
                            description = "사장님 회원 UUID",
                            example = "123e4567-e89b-12d3-a456-426614174000",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotBlank(message = "UUID는 필수 값입니다.")
                    String uuid,
            @Schema(description = "시설 이름", example = "해피 배드민턴장", requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotBlank(message = "시설 이름은 필수 값입니다.")
                    String name,
            @Schema(description = "도로명 주소", example = "서울특별시 강남구 테헤란로 123", requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotBlank(message = "도로명 주소는 필수 값입니다.")
                    String roadAddress,
            @Schema(description = "상세 주소", example = "2층 201호") String detailAddress,
            @Schema(description = "시설 카테고리", example = "BADMINTON", requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotNull(message = "카테고리는 필수 값입니다.")
                    Category category,
            @Schema(description = "시설 지역", example = "SEOUL", requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotNull(message = "지역 정보는 필수 값입니다.")
                    Region region,
            @Schema(
                            description = "큐레이션 설정 리스트",
                            example = "[\"NO_STEP_COURT_ENTRY\", \"SPORTS_WHEELCHAIR_RENTAL\"]",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    List<Curation> curations) {}
}
