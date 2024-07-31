package org.example.becoco.domain.post.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.becoco.domain.post.entity.Post;

import java.util.Date;

@Builder
@Getter
@Setter
public class PostResponse {
    String writer;
    Date createDate;
    Date updateDate;
    String type;
    String title;
    String location;
    String content;
    String proFile;

    public PostResponse(String writer, Date createDate, Date updateDate, String type, String title, String location, String content, String proFile) {
        this.writer = writer;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.type = type;
        this.title = title;
        this.location = location;
        this.content = content;
        this.proFile = proFile;
    }
}
