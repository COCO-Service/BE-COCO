package org.example.becoco.domain.global.error.handler;

import org.example.becoco.domain.global.error.Entity.ErrorResponseEntity;
import org.example.becoco.domain.global.error.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponseEntity> handlerCustomException(CustomException customException){
        return ErrorResponseEntity.responseEntity(customException.getErrorCode());
    }

}

