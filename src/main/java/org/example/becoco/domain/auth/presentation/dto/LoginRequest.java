package org.example.becoco.domain.auth.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {
    private String userName;
    private String password;
    private String role;
}
