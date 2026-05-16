package com.dteam.neordinarydteam.domain.facility.exception;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.exception.GeneralException;

public class FacilityException extends GeneralException {
    public FacilityException(BaseErrorCode code) {
        super(code);
    }
}
