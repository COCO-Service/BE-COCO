package org.example.becoco.domain.post.dto.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record PostResponse(
        Date updateDate,
        boolean type,
        String title,
        String location,
        String content
) {
    public PostResponse postResponse(Date updateDate, String title, String location, String content) {}
}
