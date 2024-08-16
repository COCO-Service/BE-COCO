package org.example.becoco.domain.user.exception;

import org.example.becoco.global.error.exception.CustomException;
import org.example.becoco.global.error.exception.ErrorCode;


public class UserNotCorrectException extends CustomException {
    public static final CustomException EXCEPTION = new UserNotCorrectException();

    private UserNotCorrectException() {
        super(ErrorCode.USER_NOT_CORRECT);
    }
}
