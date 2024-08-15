package org.example.becoco.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.response.PostListElement;
import org.example.becoco.domain.post.dto.response.PostListResponse;
import org.example.becoco.domain.post.entity.type.Type;
import org.example.becoco.domain.post.repository.PostRepository;
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
                // 악명함수, 람다식
                .map(post -> {
                    return PostListElement.builder()
                            .createDate(post.getCreateDate())
                            .updateDate(post.getUpdateDate())
                            .title(post.getTitle())
                            .build();
                })
                .collect(Collectors.toList());

        return new PostListResponse(postList);
    }

    @Transactional(readOnly = true)
    public PostListResponse allPostsView() {
        List<PostListElement> postList = postRepository.findAll()
                .stream()
                // 악명함수, 람다식
                .map(post -> {
                    return PostListElement.builder()
                            .createDate(post.getCreateDate())
                            .updateDate(post.getUpdateDate())
                            .title(post.getTitle())
                            .build();
                })
                .collect(Collectors.toList());

        return new PostListResponse(postList);
    }
}