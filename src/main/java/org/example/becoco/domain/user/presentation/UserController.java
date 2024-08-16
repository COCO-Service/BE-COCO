package org.example.becoco.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.post.presentation.dto.response.PostListResponse;
import org.example.becoco.domain.user.presentation.dto.response.UserInfoResponse;
import org.example.becoco.domain.user.service.UserInfoService;
import org.example.becoco.domain.user.service.UserPostsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class UserController {

    private final UserInfoService userInfoService;

    private final UserPostsService userPostsService;

    @GetMapping("/userinfo")
    public UserInfoResponse getUserInfo() {
        return userInfoService.execute();
    }

    @GetMapping("/posts")
    public PostListResponse getUserPosts() {
        return userPostsService.execute();
    }
}
