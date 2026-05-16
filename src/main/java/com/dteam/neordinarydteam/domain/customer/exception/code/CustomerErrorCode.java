package com.dteam.neordinarydteam.domain.customer.exception.code;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomerErrorCode implements BaseErrorCode {
    // Domain - Customer
    CUSTOMER_BAD_REQUEST(HttpStatus.BAD_REQUEST, "CUSTOMER400_1", "잘못된 입력 값입니다."),
    CUSTOMER_NOT_FOUND(HttpStatus.NOT_FOUND, "CUSTOMER404_1", "요청한 회원을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
