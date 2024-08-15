package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.Exception.PostNotDeleteException;
import org.example.becoco.domain.post.facade.PostFacade;
import org.example.becoco.domain.post.repository.PostRepository;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.user.UserFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDeleteService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;
    private final PostFacade postFacade;

    public void postDelete(Long id) {
        User user = userFacade.getCurrentUser();
        Post post = postFacade.findPostById(id);
        boolean checkPostWriter = !(user.getId().equals(post.getUser().getId()));

        if (checkPostWriter) {
            throw PostNotDeleteException.EXCEPTION;
        }

        postRepository.delete(post);
    }
}
