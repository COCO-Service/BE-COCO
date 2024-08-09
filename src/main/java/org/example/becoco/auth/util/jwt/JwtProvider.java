package org.example.becoco.auth.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.becoco.auth.Service.AuthDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);
    private final JwtProperties jwtProperties;
    private final AuthDetailsService customUserDetailsService;

    // Access token 생성
    public String createAccessToken(String accountId, String type, List<String> roles) {
        Date now = new Date();
        LOGGER.info("Creating access token for accountId: {}, type: {}, roles: {}", accountId, type, roles);

        String token = Jwts.builder()
                .setSubject(accountId)
                .setHeaderParam("type", type)
                .claim("roles", roles)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getAccessTime() * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();

        LOGGER.info("Access token created: {}", token);
        return token;
    }

    // 토큰에 담겨있는 userId로 SpringSecurity Authentication 정보를 반환하는 메서드
    public Authentication getAuthentication(String token) {
        LOGGER.info("Getting authentication for token: {}", token);
        Claims claims = getClaims(token);
        String username = claims.getSubject();

        // Extract roles
        List<String> roles = claims.get("roles", List.class);
        LOGGER.info("Roles extracted from token: {}", roles);

        // Convert roles to GrantedAuthority list with "ROLE_" prefix
        List<GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        LOGGER.info("Authentication created for user: {}", username);
        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    private Claims getClaims(String token) {
        try {
            LOGGER.info("Parsing token to get claims: {}", token);
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            LOGGER.error("Expired JWT token", e);
            throw new RuntimeException("Expired JWT token");
        } catch (Exception e) {
            LOGGER.error("Invalid JWT token", e);
            throw new RuntimeException("Invalid JWT token");
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());
        LOGGER.info("Resolving token from request header: {}", bearerToken);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getPrefix())) {
            String token = bearerToken.substring(jwtProperties.getPrefix().length());
            LOGGER.info("Token resolved: {}", token);
            return token;
        }
        LOGGER.warn("Bearer token is empty or does not start with the correct prefix.");
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).parseClaimsJws(token);
            LOGGER.info("Token is valid: {}", token);
            return true;
        } catch (ExpiredJwtException e) {
            LOGGER.warn("Expired JWT token: {}", token, e);
        } catch (Exception e) {
            LOGGER.warn("Invalid JWT token: {}", token, e);
        }
        return false;
    }
}
