package com.dteam.neordinarydteam.domain.bookmark.exception;

import com.dteam.neordinarydteam.global.apiPayload.code.BaseErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.exception.GeneralException;

public class BookmarkException extends GeneralException {
    public BookmarkException(BaseErrorCode code) {
        super(code);
    }
}
