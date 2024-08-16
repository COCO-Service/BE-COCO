package org.example.becoco.domain.post.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class PostCreateRequest {
    private String title;
    private String location;
    private String content;
}
