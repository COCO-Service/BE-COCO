package org.example.becoco.domain.user.Exception;

import org.example.becoco.global.error.ErrorCode;
import org.example.becoco.domain.global.error.exception.CustomException;


public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
