package com.dteam.neordinarydteam.domain.like.dto.response;

import com.dteam.neordinarydteam.domain.facility.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public final class LikeResponse {
    private LikeResponse() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "LikeCreateResponse", description = "찜 생성 응답 객체")
    public record CreateDTO(
            @Schema(description = "고객 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid) {}

    @Schema(description = "찜 여부 확인 응답 객체")
    public record ExistDTO(
            @Schema(description = "고객 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid,
            @Schema(description = "찜 활성화 여부", example = "true") boolean isLiked) {}

    @Schema(description = "나의 찜 목록 상세 조회 응답 객체")
    public record MyDTO(
            @Schema(description = "고객 고유 UUID", example = "123e4567-e89b-12d3-a456-426614174000") UUID uuid,
            @Schema(description = "시설물 대표 이미지 URL", example = "https://image.com/facility/1.png") String image,
            @Schema(description = "시설물 명칭", example = "강남 스포츠 센터") String name,
            @Schema(description = "시설물 카테고리") Category category,
            @Schema(description = "시설물 연관 해시태그 리스트", example = "[\"`#역세권`\", \"`#체육관`\"]") List<String> hashTags,
            @Schema(description = "찜 활성화 여부 (내 목록이므로 항상 true)", example = "true") boolean isLiked) {}
}
