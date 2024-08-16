package org.example.becoco.domain.auth.facade;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.auth.domain.Auth;
import org.example.becoco.domain.auth.exception.UserNotFoundException;
import org.example.becoco.domain.auth.domain.repository.AuthRepository;
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
