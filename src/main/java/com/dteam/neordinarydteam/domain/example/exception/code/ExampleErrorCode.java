package com.dteam.neordinarydteam.domain.example.exception.code;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExampleErrorCode implements BaseErrorCode {
    // Domain - Example
    EXAMPLE_BAD_REQUEST(HttpStatus.BAD_REQUEST, "EXAMPLE400_1", "잘못된 입력 값입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
