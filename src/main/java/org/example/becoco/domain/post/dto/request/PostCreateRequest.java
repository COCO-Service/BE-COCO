package org.example.becoco.domain.post.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostCreateRequest {
    String writer;
    String title;
    String type;
    String location;
    String content;
}
