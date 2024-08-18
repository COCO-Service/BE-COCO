package org.example.becoco.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.user.domain.User;
import org.example.becoco.domain.user.domain.repository.UserRepository;
import org.example.becoco.domain.user.exception.UserNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        return userRepository.findByUserId(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }
}
