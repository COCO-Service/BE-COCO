
package org.example.becoco.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.request.PostCreateRequest;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCreateService {
    private final PostRepository postRepository;

    public void postCreate(PostCreateRequest request) {
        postRepository.save(
            Post.builder()
                    .writer(request.getWriter())
                    .type(request.getType())
                    .title(request.getTitle())
                    .location(request.getLocation())
                    .content(request.getContent())
                    .build()
        );
    }
}
