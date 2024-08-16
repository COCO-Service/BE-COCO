package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.presentation.dto.request.PostUpdateRequest;
import org.example.becoco.domain.post.domain.Post;
import org.example.becoco.domain.post.facade.PostFacade;
import org.example.becoco.domain.post.domain.repository.PostRepository;
import org.example.becoco.domain.user.exception.UserNotCorrectException;
import org.example.becoco.domain.user.domain.User;
import org.example.becoco.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostUpdateService {
    private final PostRepository postRepository;
    private final PostFacade postFacade;
    private final UserFacade userFacade;

    public void updatePost(long id, PostUpdateRequest request) {
        User user = userFacade.getCurrentUser();
        Post post = postFacade.findPostById(id);

        boolean checkPostWriter = !(user.getId().equals(post.getUser().getId()));

        if (checkPostWriter) {
            throw UserNotCorrectException.EXCEPTION;
        }

        post.update(
            request.getTitle(),
            request.getLocation(),
            request.getContent()
        );
        postRepository.save(post);
    }
}