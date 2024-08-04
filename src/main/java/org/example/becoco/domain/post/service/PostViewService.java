package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.response.PostResponse;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostViewService {
    private final PostRepository postRepository;

    public PostResponse postView(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("post를 찾을 수 없습니다."));

        return new PostResponse(post);
    }


}
