package org.example.becoco.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.user.domain.User;
import org.example.becoco.domain.user.domain.repository.UserRepository;
import org.example.becoco.domain.user.presentation.dto.request.LoginRequest;
import org.example.becoco.global.security.jwt.JwtProvider;
import org.example.becoco.domain.user.presentation.dto.response.TokenResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {
        User auth = userRepository.findByUserId(loginRequest.getUserId()).orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        if (!passwordEncoder.matches(loginRequest.getPassword(), auth.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        System.out.println(auth.getUserId());

        // 역할을 단일 문자열로 제공
        return jwtProvider.getToken(auth);
    }


    @Transactional
    public void signup(LoginRequest loginRequest) {
        userRepository.save(
                User.builder()
                        .userId(loginRequest.getUserId())
                        .password(passwordEncoder.encode(loginRequest.getPassword()))
                        .role(loginRequest.getRole())
                        .build()
        );

    }
}
