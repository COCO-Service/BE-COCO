package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.response.PostListResponse;
import org.example.becoco.domain.post.dto.response.PostResponse;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostViewService {
    private final PostRepository postRepository;

    public PostResponse postView(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("고객은 NULL일 수 없습니다."));

        return new PostResponse(post.getWriter(), post.getCreateDate(), post.getUpdateDate(), post.getType(), post.getTitle(), post.getLocation(), post.getContent());
    }

}
