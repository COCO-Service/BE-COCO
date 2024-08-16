package org.example.becoco.domain.auth.exception;

import org.example.becoco.global.error.exception.ErrorCode;
import org.example.becoco.global.error.exception.CustomException;

public class ExpiredTokenException extends CustomException {

    public static final CustomException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException(){
        super(ErrorCode.JWT_EXPIRED);
    }
}
