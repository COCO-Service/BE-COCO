package org.example.becoco.domain.post.presentation;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.presentation.dto.response.PostListResponse;
import org.example.becoco.domain.post.domain.type.Type;
import org.example.becoco.domain.post.service.PostListViewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {
    private final PostListViewService listViewService;

    @GetMapping("/list")
    public PostListResponse postTypeLitView(@RequestParam("type") Type type){
        return listViewService.typePostsView(type);
    }

    @GetMapping("/list/all")
    public PostListResponse postAllLitView(){
        return listViewService.allPostsView();
    }
}
