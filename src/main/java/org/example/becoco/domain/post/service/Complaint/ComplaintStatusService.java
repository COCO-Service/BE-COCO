package org.example.becoco.domain.post.service.Complaint;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.domain.Post;
import org.example.becoco.domain.post.domain.repository.PostRepository;
import org.example.becoco.domain.post.facade.PostFacade;
import org.example.becoco.domain.post.presentation.dto.request.ComplaintStatusRequest;
import org.example.becoco.domain.user.domain.User;
import org.example.becoco.domain.user.exception.UserNotCorrectException;
import org.example.becoco.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComplaintStatusService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;
    private final PostFacade postFacade;

    public void statusChange(Long id, ComplaintStatusRequest request) {
        User user = userFacade.getCurrentUser();
        Post post = postFacade.findPostById(id);

        boolean checkPostWriter = !(user.getUserId().equals(post.getUser().getUserId()));

        if (checkPostWriter) {
            throw UserNotCorrectException.EXCEPTION;
        }

        post = Post.builder()
                .status(request.isStatus())
                .build();

        postRepository.save(post);
    }
}
