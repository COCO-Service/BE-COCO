package org.example.becoco.domain.post.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.example.becoco.domain.post.domain.Post;

import java.time.LocalDate;

@Getter
@Setter
public class PostResponse {
    LocalDate createDate;
    LocalDate updateDate;
    String title;
    String location;
    String content;

    public PostResponse(Post post) {
        this.createDate = post.getCreateDate();
        this.updateDate = post.getUpdateDate();
        this.title = post.getTitle();
        this.location = post.getLocation();
        this.content = post.getContent();
    }
}