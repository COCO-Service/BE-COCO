package org.example.becoco.auth.exception;

import org.example.becoco.auth.util.error.ErrorCode;
import org.example.becoco.auth.util.error.exception.CustomException;

public class UserMissMatchException extends CustomException {
    public static final CustomException EXCEPTION = new UserMissMatchException();

    public UserMissMatchException() {super (ErrorCode.USER_MISS_MATCH);}
}
