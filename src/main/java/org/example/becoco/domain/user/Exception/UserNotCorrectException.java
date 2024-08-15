package org.example.becoco.domain.user.Exception;

import org.example.becoco.domain.global.error.exception.ErrorCode;
import org.example.becoco.domain.global.error.exception.GlobalException;


public class UserNotCorrectException extends GlobalException {
    public static final GlobalException EXCEPTION = new UserNotCorrectException();

    private UserNotCorrectException() {
        super(ErrorCode.USER_NOT_CORRECT);
    }
}
