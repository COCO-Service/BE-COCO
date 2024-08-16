package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.presentation.dto.response.PostResponse;
import org.example.becoco.domain.post.facade.PostFacade;
import org.example.becoco.domain.post.domain.repository.PostRepository;
import org.example.becoco.domain.post.domain.Post;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostViewService {
    private final PostRepository postRepository;
    private final PostFacade postFacade;

    public PostResponse postView(long id) {
        Post post = postFacade.findPostById(id);

        return new PostResponse(post);
    }


}
