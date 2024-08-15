package org.example.becoco.domain.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_CORRECT(401, "USER-401", "USER NOT CORRECT."),
    USER_NOT_FOUND(404, "USER-404","USER NOT FOUND."),

    POST_NOT_FOUND(404, "POST-404-1","POST NOT FOUND."),
    POST_NOT_DELETE(401, "POST-401-1", "POST Not Delete"),
    POST_NOT_UPDATE(401, "POST-401-2", "POST Not Update"),

    INTERNAL_SERVER_ERROR(500, "COMMON-500", "Internal Server Error");

    private final int status;
    private final String code;
    private final String message;
}
