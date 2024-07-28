
package org.example.becoco.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.request.PostRequest;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCreateService {
    private final PostRepository postRepository;

    public void postCreate(PostRequest request) {
        postRepository.save(
            Post.builder()
                    .postId(request.getPostId())
                    .writer(request.getWriter())
                    .createDate(request.getCreateDate())
                    .type(request.getType())
                    .title(request.getTitle())
                    .location(request.getLocation())
                    .content(request.getContent())
                    .build()
        );
    }
}
