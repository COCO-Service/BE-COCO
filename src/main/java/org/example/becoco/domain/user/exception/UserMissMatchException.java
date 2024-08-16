package org.example.becoco.domain.user.exception;

import org.example.becoco.global.error.exception.ErrorCode;
import org.example.becoco.global.error.exception.CustomException;

public class UserMissMatchException extends CustomException {
    public static final CustomException EXCEPTION = new UserMissMatchException();

    public UserMissMatchException() {super (ErrorCode.USER_MISS_MATCH);}
}
