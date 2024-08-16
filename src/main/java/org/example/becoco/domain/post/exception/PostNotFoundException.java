package org.example.becoco.domain.post.exception;

import org.example.becoco.global.error.exception.ErrorCode;
import org.example.becoco.global.error.exception.CustomException;


public class PostNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
