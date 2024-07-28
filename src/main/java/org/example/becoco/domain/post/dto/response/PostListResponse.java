package org.example.becoco.domain.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.becoco.domain.post.entity.Post;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class PostListResponse  {
    private Date updateDate;
    private String type;
    private String title;
    private String location;
    private String content;

    public static PostListResponse of(Post post) {
        return PostListResponse.builder()
                .updateDate(post.getUpdateDate())
                .type(post.getType())
                .title(post.getTitle())
                .location(post.getLocation())
                .content(post.getContent())
                .build();
    }
}
