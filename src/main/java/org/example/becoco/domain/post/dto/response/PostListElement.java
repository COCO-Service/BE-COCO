package org.example.becoco.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.example.becoco.domain.post.entity.type.Type;
import org.example.becoco.domain.user.domain.User;

import java.time.LocalDate;

@Getter
@Builder
public class PostListElement {
    private Type type;
    private String title;
    private User user;
    private LocalDate createDate;
    private boolean solved;
}
