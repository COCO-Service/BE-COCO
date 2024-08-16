package org.example.becoco.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    POST_NOT_FOUND(404, "POST NOT FOUND."),
    POST_NOT_DELETE(401, "POST Not Delete"),
    POST_NOT_UPDATE(401, "POST Not Update"),

    USER_NOT_FOUND(404, "User Not Found"),
    COMMENT_NOT_FOUND(404, "Feed Not Found"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),
    PASSWORD_MISS_MATCH(400, "Password Miss Match"),
    USER_MISS_MATCH(403,"User Miss Match"),
    USER_NOT_CORRECT(401, "USER NOT CORRECT."),

    JWT_EXPIRED(401, "Jwt Expired"),
    JWT_INVALID(401, "Jwt Invalid"),

    TAG_GENERATION_COUNT_EXCEEDED(400, "Tag Generation Count Exceeded"),

    STAR_EXIST(409, "Star Exist"),
    REMOVE_STAR_EXIST(409, "Remove Star Exist");

    private final Integer httpStatus;
    private final String message;
}