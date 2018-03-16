package com.s2u2m.mindfly.account.token;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config/token.properties")
@ConfigurationProperties(prefix = "mindfly.token")
@Getter
@Setter
public class TokenProperty {
    private int expireMs;
}
