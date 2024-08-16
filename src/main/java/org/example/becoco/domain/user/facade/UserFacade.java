package org.example.becoco.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.user.Exception.UserNotFoundException;
import org.example.becoco.domain.user.domain.User;
import org.example.becoco.domain.user.domain.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade{

    private final UserRepository userRepository;

    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않는 유저입니다.");
        }

        String userId = authentication.getName();

        return userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
