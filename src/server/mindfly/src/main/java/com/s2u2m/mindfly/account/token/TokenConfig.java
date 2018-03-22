package com.s2u2m.mindfly.account.token;

import com.s2u2m.mindfly.account.token.redis.RedisTokenOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class TokenConfig {

    @Autowired
    TokenProperty property;

    @Bean
    IUserTokenOp userTokenOp() {
        return new RedisTokenOp(property);
    }
}
