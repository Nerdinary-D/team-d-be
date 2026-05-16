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
    INVALID_UUID(HttpStatus.BAD_REQUEST, "FACILITY400_1", "유효하지 않은 UUID 형식입니다."),
    GEOCODING_FAILED(HttpStatus.BAD_REQUEST, "FACILITY400_2", "주소 좌표 변환에 실패했습니다."),
    IMAGE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "FACILITY500_1", "이미지 업로드에 실패했습니다."),
    CUSTOMER_NOT_FOUND(HttpStatus.NOT_FOUND, "FACILITY404_3", "고객 정보를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
