/*
package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.response.PostListResponse;
import org.example.becoco.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostListViewService {
    private final PostRepository postRepository;

    public List<PostListResponse> allPostsView() {
        return postRepository.findAll()
                .stream()
                .map(PostListResponse::new)
                .toList();
    }


}
*/
