package org.example.becoco.domain.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.becoco.domain.post.entity.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class PostListResponse  {
    private LocalDate createDate;
    private LocalDate updateDate;
    private String type;
    private String title;

    public static PostListResponse of(Post post) {
        return PostListResponse.builder()
                .createDate(post.getCreateDate())
                .updateDate(post.getUpdateDate())
                .type(post.getType())
                .title(post.getTitle())
                .build();
    }
}
