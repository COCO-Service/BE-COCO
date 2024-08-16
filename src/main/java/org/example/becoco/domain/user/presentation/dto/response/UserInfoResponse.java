package org.example.becoco.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInfoResponse {

    private String name;

    private String userid;
}

