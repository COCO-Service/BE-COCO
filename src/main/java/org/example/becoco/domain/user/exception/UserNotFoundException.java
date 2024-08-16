package org.example.becoco.domain.user.exception;

import org.example.becoco.global.error.exception.CustomException;
import org.example.becoco.global.error.exception.ErrorCode;


public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
