package org.example.becoco.domain.global.error;

import lombok.Builder;

public class ErrorResponse {
    private final int status;
    private final String code;
    private final String message;

    @Builder
    ErrorResponse(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
