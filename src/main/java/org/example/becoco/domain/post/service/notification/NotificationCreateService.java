
package org.example.becoco.domain.post.service.notification;


import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.request.PostCreateRequest;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.entity.type.Type;
import org.example.becoco.domain.post.repository.PostRepository;
import org.example.becoco.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationCreateService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    public void postCreate(PostCreateRequest request) {
        User user = userFacade.getCurrentUser();

        Post post = Post.builder()
                .title(request.getTitle())
                .location(request.getLocation())
                .content(request.getContent())
                .user(user)
                .build();
        
        post.typeWrite(Type.NOTIFICATION);

        postRepository.save(post);
    }
}
