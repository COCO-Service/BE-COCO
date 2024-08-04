package org.example.becoco.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
    String proFile;

    public PostResponse(String writer, LocalDate createDate, LocalDate updateDate, String type, String title, String location, String content) {
        this.writer = writer;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.type = type;
        this.title = title;
        this.location = location;
        this.content = content;
    }

}
