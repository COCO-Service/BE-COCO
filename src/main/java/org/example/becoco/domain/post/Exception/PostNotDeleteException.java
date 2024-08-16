package org.example.becoco.domain.post.Exception;

import org.example.becoco.domain.global.error.ErrorCode;
import org.example.becoco.domain.global.error.exception.CustomException;


public class PostNotDeleteException extends CustomException {
    public static final CustomException EXCEPTION = new PostNotDeleteException();

    private PostNotDeleteException() {
        super(ErrorCode.POST_NOT_DELETE);
    }
}
