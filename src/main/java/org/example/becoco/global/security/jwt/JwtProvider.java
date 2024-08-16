package org.example.becoco.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.becoco.global.security.principle.AuthDetailsService;
import org.example.becoco.domain.auth.presentation.dto.TokenResponse;
import org.example.becoco.domain.auth.domain.Auth;
import org.example.becoco.domain.auth.exception.ExpiredTokenException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponse getToken(Auth auth) {
        String accessToken = generateAccessToken(auth.getUserName());
        return new TokenResponse(accessToken, jwtProperties.getAccessTokenTime());
    }

    public String generateAccessToken(String accountId) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(accountId);
        String role = userDetails.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN")) ? "ROLE_ADMIN" : "ROLE_USER";
        return generateToken(accountId, "access", jwtProperties.getAccessTokenTime(), role);
    }

    private String generateToken(String accountId, String type, Long exp, String role) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey().getBytes())
                .setSubject(accountId)
                .claim("type", type)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperties.getHeader());
        return parseToken(bearer);
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix()))
            return bearerToken.replace(jwtProperties.getPrefix(), "");
        return null;
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey().getBytes())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw ExpiredTokenException.EXCEPTION;
        }
    }

    public String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    public String getTokenType(String token) {
        return getTokenBody(token).get("type", String.class);
    }

    public Date getTokenIssuedAt(String token) {
        return getTokenBody(token).getIssuedAt();
    }

    public Date getTokenExpiration(String token) {
        return getTokenBody(token).getExpiration();
    }

    public String getTokenRole(String token) {
        return getTokenBody(token).get("role", String.class);
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = getTokenBody(token);
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
