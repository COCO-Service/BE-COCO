package org.example.becoco.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PostListElement {
    private LocalDate createDate;
    private LocalDate updateDate;
    private String title;
}
