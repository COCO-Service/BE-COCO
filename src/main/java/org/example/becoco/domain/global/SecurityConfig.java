package org.example.becoco.domain.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/post/notification/write").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/post/notification/view").hasRole("STUDENT"+"ADMIN")
                        .requestMatchers(HttpMethod.GET,"/post/complaint/*").hasRole("STUDENT"+"ADMIN")
                        .requestMatchers(HttpMethod.GET,"/post/notification/*").hasRole("STUDENT"+"ADMIN")
                        .anyRequest().permitAll())
                .build();
    }
}
