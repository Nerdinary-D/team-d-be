package com.dteam.neordinarydteam.domain.facility.exception.code;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum FacilityErrorCode implements BaseErrorCode {
    FACILITY_NOT_FOUND(HttpStatus.NOT_FOUND, "FACILITY404_1", "시설을 찾을 수 없습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "FACILITY404_2", "회원을 찾을 수 없습니다."),
    IMAGE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "FACILITY500_1", "이미지 업로드에 실패했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
