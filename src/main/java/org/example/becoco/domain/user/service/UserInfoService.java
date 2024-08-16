package org.example.becoco.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.user.domain.User;
import org.example.becoco.domain.user.facade.UserFacade;
import org.example.becoco.domain.user.presentation.dto.response.UserInfoResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserInfoService {

    private final UserFacade userFacade;

    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();

        return UserInfoResponse.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .build();
    }
}
