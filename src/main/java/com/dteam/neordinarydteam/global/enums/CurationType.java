package com.dteam.neordinarydteam.global.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CurationType {
    PHYSICAL("지체 장애"),
    VISUAL("시각 장애"),
    HEARING("청각 장애"),
    DEVELOPMENTAL("발달 장애"),
    COMMON("공통 신뢰");

    private final String description;
}
