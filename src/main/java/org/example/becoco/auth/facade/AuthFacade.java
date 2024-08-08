package org.example.becoco.auth.facade;

import lombok.RequiredArgsConstructor;
import org.example.becoco.auth.entity.Auth;
import org.example.becoco.auth.exception.UserNotFoundException;
import org.example.becoco.auth.repository.AuthRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthFacade {
    private final AuthRepository authRepository;

    public Auth getCurrentUser() {
        return authRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }
}
