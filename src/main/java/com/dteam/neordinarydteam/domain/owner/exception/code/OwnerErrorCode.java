package com.dteam.neordinarydteam.domain.owner.exception.code;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum OwnerErrorCode implements BaseErrorCode {
    OWNER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "OWNER400_1", "이미 존재하는 사장입니다."),
    OWNER_NOT_FOUND(HttpStatus.NOT_FOUND, "OWNER404_1", "사장을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
