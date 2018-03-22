package com.s2u2m.mindfly.account.service.account;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/account-config.properties")
@ConfigurationProperties(prefix = "mindfly.account")
@Getter
@Setter
public class AccountConfigProperty {
    private Integer usernameMinLen;
    private Integer usernameMaxLen;
    private Integer passwordMinLen;
    private Integer passwordMaxLen;
    private Integer phoneCodeExpire;
}
