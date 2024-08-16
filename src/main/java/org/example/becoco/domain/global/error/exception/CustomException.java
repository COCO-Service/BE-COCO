package org.example.becoco.domain.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.global.error.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
}
