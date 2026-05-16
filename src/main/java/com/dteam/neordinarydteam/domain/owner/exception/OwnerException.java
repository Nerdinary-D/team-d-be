package com.dteam.neordinarydteam.domain.owner.exception;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.exception.GeneralException;

public class OwnerException extends GeneralException {
    public OwnerException(BaseErrorCode code) {
        super(code);
    }
}
