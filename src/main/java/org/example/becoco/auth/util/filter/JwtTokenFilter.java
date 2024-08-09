package org.example.becoco.auth.util.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.becoco.auth.util.jwt.JwtProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);
    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        LOGGER.info("Filtering request: {}", requestURI);

        // /login과 /signup 요청은 필터링 X
        if ("/login".equals(requestURI) || "/signup".equals(requestURI)) {
            LOGGER.info("Skipping filter for URI: {}", requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = jwtProvider.resolveToken(request);
            LOGGER.info("Resolved token: {}", token);

            if (token == null || !StringUtils.hasText(token)) {
                LOGGER.warn("JWT Token is missing or invalid for URI: {}", requestURI);
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT Token is missing or invalid");
                return;
            }

            if (!jwtProvider.validateToken(token)) {
                LOGGER.warn("Invalid JWT token for URI: {}", requestURI);
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Invalid token");
                return;
            }

            Authentication authentication = jwtProvider.getAuthentication(token);

            if (authentication == null) {
                LOGGER.warn("Failed to get authentication from token for URI: {}", requestURI);
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                return;
            }

            LOGGER.info("Authenticated user: {}", authentication.getName());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request, response);
        } catch (RuntimeException e) {
            LOGGER.error("JWT Token Filter error", e);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
    }
}
