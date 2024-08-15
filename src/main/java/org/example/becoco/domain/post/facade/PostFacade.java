package org.example.becoco.domain.post.facade;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.Exception.PostNotFoundException;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.repository.PostRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostFacade {

    private final PostRepository postRepository;

    public Post findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> PostNotFoundException.EXCEPTION);
    }
}
