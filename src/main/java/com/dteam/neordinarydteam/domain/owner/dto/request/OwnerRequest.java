package com.dteam.neordinarydteam.domain.owner.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Schema(description = "사장 관련 요청 DTO")
public final class OwnerRequest {
    private OwnerRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "OwnerCreateRequest", description = "사장 생성 요청 객체")
    public record CreateDTO(
            @Schema(
                            description = "회원 고유 UUID",
                            example = "123e4567-e89b-12d3-a456-426614174000",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotNull(message = "UUID는 필수 값입니다.")
                    UUID uuid,
            @Schema(description = "닉네임", example = "김사장", requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotBlank(message = "닉네임은 필수 값입니다.")
                    String nickname) {}
}
