package org.example.becoco.auth.exception;

import org.example.becoco.auth.util.error.ErrorCode;
import org.example.becoco.auth.util.error.exception.CustomException;

public class UserNotFoundException extends CustomException{
    public static final CustomException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
