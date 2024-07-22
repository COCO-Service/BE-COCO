package org.example.becoco.domain.post.dto.request;

import lombok.Builder;

import java.util.Date;

@Builder
public record PostRequest(
        Long postId,
        String writer,
        Date createDate,
        Date updateDate,
        String title,
        boolean type,
        String location,
        String content
) {
}
