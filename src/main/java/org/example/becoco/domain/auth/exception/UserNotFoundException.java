package org.example.becoco.domain.auth.exception;

import org.example.becoco.global.error.exception.ErrorCode;
import org.example.becoco.global.error.exception.CustomException;

public class UserNotFoundException extends CustomException{
    public static final CustomException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
