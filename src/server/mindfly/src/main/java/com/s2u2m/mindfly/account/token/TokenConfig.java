package com.s2u2m.mindfly.account.token;

import com.s2u2m.mindfly.core.token.ITokenOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

    @Bean
    IUserTokenOp userTokenOp() {
        return new JwtTokenOp();
    }
}
