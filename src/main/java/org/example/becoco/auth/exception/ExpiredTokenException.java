package org.example.becoco.auth.exception;

import org.example.becoco.auth.util.error.ErrorCode;
import org.example.becoco.auth.util.error.exception.CustomException;

public class ExpiredTokenException extends CustomException {

    public static final CustomException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException(){
        super(ErrorCode.JWT_EXPIRED);
    }
}
