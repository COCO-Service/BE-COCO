package org.example.becoco.domain.post.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.example.becoco.domain.post.entity.Post;

import java.time.LocalDate;

@Getter
@Setter
public class PostResponse {
    String writer;
    LocalDate createDate;
    LocalDate updateDate;
    String type;
    String title;
    String location;
    String content;

    public PostResponse(Post post) {
        this.writer = post.getWriter();
        this.createDate = post.getCreateDate();
        this.updateDate = post.getUpdateDate();
        this.type = post.getType();
        this.title = post.getTitle();
        this.location = post.getLocation();
        this.content = post.getContent();
    }
}