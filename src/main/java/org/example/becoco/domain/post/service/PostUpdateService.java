package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.request.PostRequest;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostUpdateService {
    private final PostRepository postRepository;

    public void updatePost(long id, PostRequest request) {
        Post post= postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
        post.update(
            request.getPostId(),
            request.getUpdateDate(),
            request.getTitle(),
            request.getLocation(),
            request.getContent()
        );
        postRepository.save(post);
    }
}
