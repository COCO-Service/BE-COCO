package org.example.becoco.domain.user.Exception;

import org.example.becoco.domain.global.error.exception.ErrorCode;
import org.example.becoco.domain.global.error.exception.GlobalException;


public class UserNotFoundException extends GlobalException {
    public static final GlobalException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
