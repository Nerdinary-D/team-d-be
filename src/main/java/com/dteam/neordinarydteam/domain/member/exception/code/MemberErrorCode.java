package com.dteam.neordinarydteam.domain.member.exception.code;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {
    // Domain - Member
    MEMBER_BAD_REQUEST(HttpStatus.BAD_REQUEST, "MEMBER400_1", "잘못된 입력 값입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404_1", "요청한 회원을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
