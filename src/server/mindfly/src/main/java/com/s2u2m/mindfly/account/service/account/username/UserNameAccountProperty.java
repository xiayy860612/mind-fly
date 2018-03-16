package com.s2u2m.mindfly.account.service.account.username;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/account/username-limit.properties")
@ConfigurationProperties(prefix = "mindfly.account")
@Getter
@Setter
public class UserNameAccountProperty {
    private Integer usernameMinLen;
    private Integer usernameMaxLen;
    private Integer passwordMinLen;
    private Integer passwordMaxLen;
}
