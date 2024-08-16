package org.example.becoco.domain.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_CORRECT(401, "USER NOT CORRECT."),
    USER_NOT_FOUND(404, "USER NOT FOUND."),

    POST_NOT_FOUND(404, "POST NOT FOUND."),
    POST_NOT_DELETE(401, "POST Not Delete"),
    POST_NOT_UPDATE(401, "POST Not Update"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final Integer httpStatus;
    private final String message;
}
