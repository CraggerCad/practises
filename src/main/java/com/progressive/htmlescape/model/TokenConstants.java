package com.progressive.htmlescape.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "token")
@Data
public class TokenConstants {
    private String signingKey;
    private long validitySeconds;
}
