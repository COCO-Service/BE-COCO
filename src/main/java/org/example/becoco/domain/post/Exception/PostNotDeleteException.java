package org.example.becoco.domain.post.Exception;

import org.example.becoco.global.error.ErrorCode;
import org.example.becoco.global.domain.error.exception.CustomException;


public class PostNotDeleteException extends CustomException {
    public static final CustomException EXCEPTION = new PostNotDeleteException();

    private PostNotDeleteException() {
        super(ErrorCode.POST_NOT_DELETE);
    }
}
