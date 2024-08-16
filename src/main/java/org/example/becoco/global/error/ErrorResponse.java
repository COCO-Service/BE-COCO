package org.example.becoco.global.error;

import lombok.Builder;
import lombok.Getter;
import org.example.becoco.global.error.exception.ErrorCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {
    private int status;
    private String code;
    private String message;
    private LocalDateTime createLocalDateTime;

    public static ResponseEntity<ErrorResponse> responseEntity(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(errorCode.getHttpStatus())
                        .code(errorCode.name())
                        .message(errorCode.getMessage())
                        .createLocalDateTime(LocalDateTime.now())
                        .build()
                );
    }
}
