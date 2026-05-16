package com.dteam.neordinarydteam.domain.like.exception;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.exception.GeneralException;

public class LikeException extends GeneralException {
    public LikeException(BaseErrorCode code) {
        super(code);
    }
}
