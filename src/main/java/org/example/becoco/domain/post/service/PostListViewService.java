package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.presentation.dto.response.PostListElement;
import org.example.becoco.domain.post.presentation.dto.response.PostListResponse;
import org.example.becoco.domain.post.domain.type.Type;
import org.example.becoco.domain.post.domain.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostListViewService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostListResponse typePostsView(Type type) {
        List<PostListElement> postList = postRepository.findAllByType(type)
                .stream()
                // 익명함수, 람다식
                .map(post -> {
                    return PostListElement.builder()
                            .type(post.getType())
                            .title(post.getTitle())
                            .user(post.getUser())
                            .createDate(post.getCreateDate())
                            .status(post.isStatus())
                            .build();
                })
                .collect(Collectors.toList());

        return new PostListResponse(postList);
    }

    @Transactional(readOnly = true)
    public PostListResponse allPostsView() {
        List<PostListElement> postList = postRepository.findAll()
                .stream()
                // 익명함수, 람다식
                .map(post -> {
                    return PostListElement.builder()
                            .type(post.getType())
                            .title(post.getTitle())
                            .user(post.getUser())
                            .createDate(post.getCreateDate())
                            .status(post.isStatus())
                            .build();
                })
                .collect(Collectors.toList());

        return new PostListResponse(postList);
    }
}