package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDeleteService {
    private final PostRepository postRepository;

    public void postDelete(Long id) {
        Post post = postRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }
}
