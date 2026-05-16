package com.dteam.neordinarydteam.global.apiPayload.response;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.code.BaseSuccessCode;

public record ApiResponse<T>(boolean success, String code, String message, T result) {
    // 성공한 경우 (정적 팩토리 메서드)
    public static <T> ApiResponse<T> onSuccess(BaseSuccessCode code, T result) {
        return new ApiResponse<>(true, code.getCode(), code.getMessage(), result);
    }

    // 실패한 경우 (정적 팩토리 메서드)
    public static <T> ApiResponse<T> onFailure(BaseErrorCode code, T result) {
        return new ApiResponse<>(false, code.getCode(), code.getMessage(), result);
    }
}
