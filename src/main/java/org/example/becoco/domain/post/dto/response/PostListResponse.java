package org.example.becoco.domain.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostListResponse  {
    private final List<PostListElement> postList;
}
