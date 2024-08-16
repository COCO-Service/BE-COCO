package org.example.becoco.global.security.principle;

import lombok.AllArgsConstructor;
import org.example.becoco.domain.auth.domain.Auth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class AuthDetails implements UserDetails {
    private Auth auth;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한을 반환, role 필드를 사용한다고 가정
        return Collections.singletonList(new SimpleGrantedAuthority(auth.getRole()));
    }

    @Override
    public String getUsername() {
        return auth.getUserName();
    }

    @Override
    public String getPassword() {
        return auth.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}