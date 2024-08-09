package org.example.becoco.auth.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.becoco.auth.Service.AuthService;
import org.example.becoco.auth.dto.LoginRequest;
import org.example.becoco.auth.dto.TokenResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/hi")
    public String test() {
        return "tlqkf wlfkfgkwlak";
    }

    @GetMapping("/")
    public String sibal() {
        return "TLQKF";
    }

    @PostMapping("/signup")
    public void signup(@RequestBody LoginRequest loginRequest) {
        authService.signup(loginRequest);
    }

}
