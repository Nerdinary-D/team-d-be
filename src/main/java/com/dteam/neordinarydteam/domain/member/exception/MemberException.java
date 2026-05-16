package com.dteam.neordinarydteam.domain.member.exception;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.exception.GeneralException;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}
