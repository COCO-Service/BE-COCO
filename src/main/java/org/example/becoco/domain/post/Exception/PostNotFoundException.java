package org.example.becoco.domain.post.Exception;

import org.example.becoco.domain.global.error.exception.ErrorCode;
import org.example.becoco.domain.global.error.exception.GlobalException;


public class PostNotFoundException extends GlobalException {
    public static final GlobalException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
