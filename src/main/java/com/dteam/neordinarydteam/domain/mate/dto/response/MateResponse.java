package com.dteam.neordinarydteam.domain.mate.dto.response;

import com.dteam.neordinarydteam.global.enums.Region;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.UUID;

public final class MateResponse {
    private MateResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "MateCreateResponse", description = "메이트 생성 완료 응답 객체")
    public record CreateDTO(
            @Schema(description = "작성 유저의 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid,
            @Schema(description = "생성된 메이트 모집글 ID", example = "101") Long mateId,
            @Schema(description = "게시글 생성 일시") LocalDateTime createdAt) {}

    @Schema(description = "메이트 목록 조회용 단일 항목 객체")
    public record ListDTO(
            @Schema(description = "연관 시설물 고유 ID", example = "1") Long facilityId,
            @Schema(description = "시설물 소속 지역 식별자") Region region,
            @Schema(description = "모집글 제목") String title,
            @Schema(description = "만남 시간 명세") String meetingTime,
            @Schema(description = "모집글 본문 요약") String content,
            @Schema(description = "오픈채팅방 URL") String openchatLink,
            @Schema(description = "글 작성 일시") LocalDateTime createdAt) {}
}
