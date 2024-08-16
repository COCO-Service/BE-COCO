package org.example.becoco.domain.post.exception;

import org.example.becoco.global.error.exception.ErrorCode;
import org.example.becoco.global.error.exception.CustomException;


public class PostNotDeleteException extends CustomException {
    public static final CustomException EXCEPTION = new PostNotDeleteException();

    private PostNotDeleteException() {
        super(ErrorCode.POST_NOT_DELETE);
    }
}
