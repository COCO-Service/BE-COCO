package org.example.becoco.auth.util.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.becoco.auth.util.error.ErrorCode;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;
}
