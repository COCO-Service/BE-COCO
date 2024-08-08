package org.example.becoco.auth.Service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.auth.dto.LoginRequest;
import org.example.becoco.auth.entity.Auth;
import org.example.becoco.auth.exception.UserNotFoundException;
import org.example.becoco.auth.util.jwt.JwtProvider;
import org.example.becoco.auth.dto.TokenResponse;
import org.example.becoco.auth.repository.AuthRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {
        Auth auth = authRepository.findByUserName(loginRequest.getUserName()).orElseThrow(()->new RuntimeException(""));
        if (!passwordEncoder.matches(loginRequest.getPassword(), auth.getPassword())) {
            throw new RuntimeException("asdf");
        }
        System.out.println(auth.getUserName());
        return new TokenResponse(jwtProvider.createAccessToken(auth.getUserName()));

    }

    @Transactional
    public void signup(LoginRequest loginRequest) {
        authRepository.save(
                Auth.builder()
                        .userName(loginRequest.getUserName())
                        .password(passwordEncoder.encode(loginRequest.getPassword()))
                        .role(loginRequest.getRole())
                        .build()
        );

    }
}
