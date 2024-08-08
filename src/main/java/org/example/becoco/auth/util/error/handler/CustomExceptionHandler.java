package org.example.becoco.auth.util.error.handler;

import org.example.becoco.auth.util.error.entity.ErrorResponseEntity;
import org.example.becoco.auth.util.error.exception.CustomException;
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
