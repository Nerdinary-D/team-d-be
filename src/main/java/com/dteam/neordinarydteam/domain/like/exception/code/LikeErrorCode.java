package com.dteam.neordinarydteam.domain.like.exception.code;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum LikeErrorCode implements BaseErrorCode {
    // Domain - Like
    EXAMPLE_BAD_REQUEST(HttpStatus.BAD_REQUEST, "EXAMPLE400_1", "잘못된 입력 값입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
