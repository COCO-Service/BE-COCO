package org.example.becoco.domain.user;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.user.Exception.UserNotFoundException;
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
