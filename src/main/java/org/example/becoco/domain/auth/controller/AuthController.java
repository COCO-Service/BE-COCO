package org.example.becoco.domain.auth.controller;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.auth.service.AuthService;
import org.example.becoco.domain.auth.dto.LoginRequest;
import org.example.becoco.domain.auth.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest) {
        TokenResponse tokenResponse = authService.login(loginRequest);
        return ResponseEntity.ok(tokenResponse);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody LoginRequest loginRequest) {
        authService.signup(loginRequest);
    }
}