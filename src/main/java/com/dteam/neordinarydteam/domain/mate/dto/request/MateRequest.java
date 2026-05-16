package com.dteam.neordinarydteam.domain.mate.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;

public final class MateRequest {
    private MateRequest() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Schema(name = "MateCreateRequest", description = "메이트 생성 요청 객체")
    public record CreateDTO(
            @Schema(
                            description = "작성 고객의 회원 고유 UUID",
                            example = "123e4567-e89b-12d3-a456-426614174000",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotNull(message = "고객 UUID는 필수 입력 값입니다.")
                    UUID uuid,
            @Schema(description = "모집 대상 시설물 고유 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotNull(message = "시설물 ID는 필수 입력 값입니다.")
                    Long facilityId,
            @Schema(
                            description = "모집글 제목",
                            example = "내일 저녁 배드민턴 치실 메이트 구합니다",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotBlank(message = "제목은 공백일 수 없습니다.")
                    @Size(max = 100, message = "제목은 100자 이하로 작성해주세요.")
                    String title,
            @Schema(
                            description = "만남 예정 시간 명세 (텍스트 포맷)",
                            example = "2026-05-18 19:00",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotBlank(message = "만남 시간 정보는 필수입니다.")
                    String meetingTime,
            @Schema(
                            description = "모집 상세 내용",
                            example = "초보자도 환영합니다. 라켓은 지참해주세요.",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotBlank(message = "본문 내용은 필수 입력 사항입니다.")
                    String content,
            @Schema(
                            description = "소통을 위한 오픈채팅방 링크",
                            example = "https://open.kakao.com/o/sExample",
                            requiredMode = Schema.RequiredMode.REQUIRED)
                    @NotBlank(message = "오픈채팅 링크는 필수 입력 사항입니다.")
                    String openchatLink) {}
}
