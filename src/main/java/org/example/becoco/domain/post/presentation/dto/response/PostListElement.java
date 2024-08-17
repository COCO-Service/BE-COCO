package org.example.becoco.domain.post.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.example.becoco.domain.post.domain.type.Type;
import org.example.becoco.domain.user.domain.User;

import java.time.LocalDate;

@Getter
@Builder
public class PostListElement {
    private Type type;
    private String title;
    private User user;
    private LocalDate createDate;
    private boolean status;
}
