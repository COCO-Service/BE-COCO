package org.example.becoco.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.response.PostListElement;
import org.example.becoco.domain.post.dto.response.PostListResponse;
import org.example.becoco.domain.post.repository.PostRepository;
import org.example.becoco.domain.user.domain.User;
import org.example.becoco.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserPostsService {

    private final UserFacade userFacade;

    private final PostRepository postRepository;

    public PostListResponse execute() {
        User user = userFacade.getCurrentUser();
        List<PostListElement> postList = postRepository.findAllByUser(user)
                .stream()
                .map(post -> PostListElement.builder()
                        .type(post.getType())
                        .title(post.getTitle())
                        .user(post.getUser())
                        .createDate(post.getCreateDate())
                        .solved(post.isSolved())
                        .build())
                .collect(Collectors.toList());

        return new PostListResponse(postList);
    }
}
