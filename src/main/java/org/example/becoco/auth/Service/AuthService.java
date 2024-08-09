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

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {
        Auth auth = authRepository.findByUserName(loginRequest.getUserName()).orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        if (!passwordEncoder.matches(loginRequest.getPassword(), auth.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        System.out.println(auth.getUserName());

        // 역할을 단일 문자열로 제공
        return jwtProvider.getToken(auth);
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
