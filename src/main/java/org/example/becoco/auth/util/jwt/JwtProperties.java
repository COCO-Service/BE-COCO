package org.example.becoco.auth.util.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("jwt")
public class JwtProperties {
    private Long accessTokenTime;
    private String prefix;
    private String header;
    private String secretKey;
    private Long exp;
}