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
    Date updateDate;
    String type;
    String title;
    String location;
    String content;

    public void PostResponse(Post post) {
        this.updateDate = post.getUpdateDate();
        this.type = post.getType();
        this.title = post.getTitle();
        this.location = post.getLocation();
        this.content = post.getContent();
    }
}
