package org.example.becoco.domain.post.service.notification;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.request.PostUpdateRequest;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationUpdateService {
    private final PostRepository postRepository;

    public void updatePost(long id, PostUpdateRequest request) {
        Post post= postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
        post.update(
            request.getTitle(),
            request.getLocation(),
            request.getContent()
        );
        postRepository.save(post);
    }
}
