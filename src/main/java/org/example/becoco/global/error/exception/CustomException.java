package org.example.becoco.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.becoco.global.error.ErrorCode;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;
}
