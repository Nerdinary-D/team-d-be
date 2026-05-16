package com.dteam.neordinarydteam.global.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Curation {
    // 지체 장애
    NO_STEP_COURT_ENTRY(CurationType.PHYSICAL, "실제 운동을 하는 코트 내부까지 단차 없이 진입하고 싶어요.", "#단차없는_코트진입"),
    SPORTS_WHEELCHAIR_RENTAL(CurationType.PHYSICAL, "무거운 장비를 챙길 필요 없이, 스포츠 전용 휠체어를 현장에서 대여하고 싶어요.", "#스포츠휠체어_대여"),
    ACCESSIBLE_SHOWER_ROOM(CurationType.PHYSICAL, "운동 후 휠체어를 탄 채로 편하게 이용할 수 있는 넓은 탈의/샤워실이 필수예요.", "#휠체어_전용샤워실"),

    // 시각 장애
    GUIDE_DOG_ALLOWED(CurationType.VISUAL, "시각장애인 안내견과 눈치 보지 않고 함께 입장하고 싶어요.", "#안내견_동반환영"),
    BRAILLE_INFRASTRUCTURE(CurationType.VISUAL, "안전한 이동을 위해 점자 블록과 점자 안내판이 설치되어 있어야 해요.", "#점자안내_인프라"),
    VERBAL_GUIDANCE(CurationType.VISUAL, "직원이 시설 이용법과 룰을 구체적인 말로 친절하게 안내해 주면 좋겠어요.", "#전담_구두안내"),

    // 청각 장애
    WRITTEN_COMMUNICATION(CurationType.HEARING, "수어 통역이 없어도 필담이나 태블릿으로 원활하게 소통하고 싶어요.", "#필담안내_가이드"),
    VISUAL_MANUAL(CurationType.HEARING, "말(음성) 중심의 강습보다 글과 그림 위주의 시각적인 안내 자료가 필요해요.", "#시각중심_매뉴얼"),
    VISUAL_ALARM(CurationType.HEARING, "소리 외에 불빛으로도 위험 상황을 알 수 있는 시각 알람이 필요해요.", "#비상시_시각알람"),

    // 발달 장애
    SIMPLE_SPORTS_RULE(CurationType.DEVELOPMENTAL, "복잡한 규칙을 외울 필요 없이 단순하게 바로 참여할 수 있는 운동이 좋아요.", "#단순직관_스포츠룰"),
    LOW_STIMULUS_ENVIRONMENT(CurationType.DEVELOPMENTAL, "너무 시끄럽거나 조명이 번쩍이지 않는 차분한 환경이 필요해요.", "#저자극_차분한환경"),
    PRIVATE_SPACE(CurationType.DEVELOPMENTAL, "다른 사람과 부딪히지 않고 나만의 페이스로 운동할 수 있는 공간이 필요해요.", "#프라이빗_독립공간"),

    // 공통 신뢰
    CERTIFIED_INSTRUCTOR(CurationType.COMMON, "장애인 스포츠 전문 지도자 자격증을 갖춘 강사에게 안전하게 배우고 싶어요.", "#장애인_전문지도사");

    private final CurationType type;
    private final String requirement;
    private final String hashtag;

    /**
     * 특정 장애 유형에 해당하는 체크리스트 항목만 필터링하여 반환하는 유틸리티 메서드
     */
    public static List<Curation> getByCuration(CurationType type) {
        return Arrays.stream(values()).filter(item -> item.getType() == type).collect(Collectors.toList());
    }
}
