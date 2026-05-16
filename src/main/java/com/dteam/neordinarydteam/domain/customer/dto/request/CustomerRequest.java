package com.dteam.neordinarydteam.domain.customer.dto.request;

import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Schema(description = "고객 관련 요청 DTO")
public final class CustomerRequest {
    private CustomerRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "CustomerCreateRequest", description = "고객 생성 요청 객체")
    public record CreateDTO(
            @Schema(
                            description = "회원 고유 UUID",
                            example = "123e4567-e89b-12d3-a456-426614174000",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotNull(message = "UUID는 필수 값입니다.")
                    UUID uuid,
            @Schema(
                            description = "큐레이션 설정 리스트",
                            example = "[\"NO_STEP_COURT_ENTRY\", \"GUIDE_DOG_ALLOWED\"]",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotEmpty(message = "큐레이션 정보는 최소 하나 이상 필요합니다.")
                    List<@NotNull(message = "큐레이션 항목은 null일 수 없습니다.") Curation> curations) {}

    @Schema(description = "고객 정보 수정 요청 객체")
    public record UpdateDTO(
            @Schema(
                            description = "변경할 큐레이션 설정 리스트",
                            example = "[\"GUIDE_DOG_ALLOWED\"]",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotEmpty(message = "큐레이션 정보는 최소 하나 이상 필요합니다.")
                    List<@NotNull(message = "큐레이션 항목은 null일 수 없습니다.") Curation> curations,
            @Schema(description = "변경할 활동 지역", example = "BUSAN", requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotNull(message = "지역 정보는 필수 값입니다.")
                    Region region) {}
}
