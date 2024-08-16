package org.example.becoco.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.user.exception.UserNotFoundException;
import org.example.becoco.domain.user.domain.User;
import org.example.becoco.domain.user.domain.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade{

    private final UserRepository userRepository;

    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public User getCurrentUser() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUserId(userId);
    }
}
