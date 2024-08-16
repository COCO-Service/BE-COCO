package org.example.becoco.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.example.becoco.domain.user.service.AuthService;
import org.example.becoco.domain.user.presentation.dto.request.LoginRequest;
import org.example.becoco.domain.user.presentation.dto.response.TokenResponse;
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