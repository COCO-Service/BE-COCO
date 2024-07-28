package org.example.becoco.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.dto.request.PostRequest;
import org.example.becoco.domain.post.dto.response.PostListResponse;
import org.example.becoco.domain.post.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostCreateService createService;
    private final PostDeleteService deleteService;
    private final PostViewService viewService;
    private final PostListViewService postListViewService;
    private final PostUpdateService updateService;

    @PostMapping("/write")
    private void postWrite(@RequestBody PostRequest request) {
        createService.postCreate(request);
    }

    @DeleteMapping("/{id}")
    private void postDelete(@PathVariable("id") Long id) {
        deleteService.postDelete(id);
    }

    @GetMapping("/{id}")
    private void postView(@PathVariable("id") Long id) {
        viewService.postView(id);
    }

    @GetMapping()
    public List<PostListResponse> postLitView(){
        return postListViewService.allPostsView();
    }

    @PatchMapping("/{id}")
    private void postUpdate(@PathVariable("id") Long id, @RequestBody PostRequest request) {
        updateService.updatePost(id, request);
    }
}
