package org.example.becoco.domain.post.Exception;

import org.example.becoco.domain.global.error.exception.ErrorCode;
import org.example.becoco.domain.global.error.exception.GlobalException;


public class PostNotDeleteException extends GlobalException {
    public static final GlobalException EXCEPTION = new PostNotDeleteException();

    private PostNotDeleteException() {
        super(ErrorCode.POST_NOT_DELETE);
    }
}
