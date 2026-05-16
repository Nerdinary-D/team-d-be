package com.dteam.neordinarydteam.domain.example.exception;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.exception.GeneralException;

public class ExampleException extends GeneralException {
    public ExampleException(BaseErrorCode code) {
        super(code);
    }
}
