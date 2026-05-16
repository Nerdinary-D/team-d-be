package com.dteam.neordinarydteam.domain.customer.dto.response;

import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Schema(description = "고객 관련 응답 DTO 컨테이너")
public final class CustomerResponse {
    private CustomerResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(description = "고객 생성 완료 응답 객체")
    public record CreateDTO(
            @Schema(description = "생성된 고객의 회원 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid,
            @Schema(description = "생성 일시") LocalDateTime createdAt) {}

    @Schema(description = "고객 수정 완료 응답 객체")
    public record UpdateDTO(
            @Schema(description = "수정된 고객의 회원 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid,
            @Schema(description = "수정 일시") LocalDateTime updatedAt) {}

    @Schema(description = "고객 삭제 완료 응답 객체")
    public record DeleteDTO(
            @Schema(description = "삭제된 고객의 회원 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid,
            @Schema(description = "삭제 일시") LocalDateTime deletedAt) {}

    @Schema(description = "고객 프로필 상세 조회 응답 객체")
    public record MyProfileDTO(
            @Schema(description = "고객의 회원 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid,
            @Schema(description = "현재 큐레이션 상태 리스트") List<Curation> curations,
            @Schema(description = "현재 설정 지역") Region region,
            @Schema(description = "가입 일시") LocalDateTime createdAt) {}
}
