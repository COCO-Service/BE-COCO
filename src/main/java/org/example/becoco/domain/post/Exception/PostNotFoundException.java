package org.example.becoco.domain.post.Exception;

import org.example.becoco.global.error.ErrorCode;
import org.example.becoco.domain.global.error.exception.CustomException;


public class PostNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
