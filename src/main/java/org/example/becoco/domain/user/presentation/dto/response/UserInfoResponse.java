package org.example.becoco.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserPostResponse {

    private String title;

    private String createdAt;

    private String isCompleted;
}

