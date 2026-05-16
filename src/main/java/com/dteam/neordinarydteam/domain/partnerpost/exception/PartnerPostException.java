package com.dteam.neordinarydteam.domain.partnerpost.exception;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.exception.GeneralException;

public class PartnerPostException extends GeneralException {
    public PartnerPostException(BaseErrorCode code) {
        super(code);
    }
}
