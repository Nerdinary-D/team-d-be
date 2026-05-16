package com.dteam.neordinarydteam.domain.customer.exception;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.exception.GeneralException;

public class CustomerException extends GeneralException {
    public CustomerException(BaseErrorCode code) {
        super(code);
    }
}
