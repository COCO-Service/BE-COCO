package org.example.becoco.auth.Service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.auth.repository.AuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {
    private final AuthRepository authFacade;

    @Override
    public UserDetails loadUserByUsername(String email) {
        return new AuthDetails(authFacade.findByUserName(email).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다.")));
    }
}