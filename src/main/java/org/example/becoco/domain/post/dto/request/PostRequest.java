package org.example.becoco.domain.post.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class PostRequest {
    Long postId;
    String writer;
    Date createDate;
    Date updateDate;
    String title;
    String type;
    String location;
    String content;
    String proFile;
}
