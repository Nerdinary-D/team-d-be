package com.dteam.neordinarydteam.domain.mate.exception;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.exception.GeneralException;

public class MateException extends GeneralException {
    public MateException(BaseErrorCode code) {
        super(code);
    }
}
