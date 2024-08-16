package org.example.becoco.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(404, "User Not Found"),
    COMMENT_NOT_FOUND(404, "Feed Not Found"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),
    PASSWORD_MISS_MATCH(400, "Password Miss Match"),
    USER_MISS_MATCH(403,"User Miss Match"),

    JWT_EXPIRED(401, "Jwt Expired"),
    JWT_INVALID(401, "Jwt Invalid"),

    TAG_GENERATION_COUNT_EXCEEDED(400, "Tag Generation Count Exceeded"),

    STAR_EXIST(409, "Star Exist"),
    REMOVE_STAR_EXIST(409, "Remove Star Exist");

    private final Integer httpStatus;
    private final String message;
}