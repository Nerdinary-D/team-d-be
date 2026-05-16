package com.dteam.neordinarydteam.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode implements BaseSuccessCode {
    OK(HttpStatus.OK, "COMMON200_1", "요청이 정상적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "COMMON201_1", "리소스가 성공적으로 생성되었습니다."),
    ACCEPTED(HttpStatus.ACCEPTED, "COMMON202_1", "요청이 접수되었습니다. 처리에 시간이 소요될 수 있습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
