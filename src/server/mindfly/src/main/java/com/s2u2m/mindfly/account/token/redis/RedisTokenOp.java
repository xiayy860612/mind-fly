package com.s2u2m.mindfly.account.token.redis;

import com.s2u2m.mindfly.account.token.IUserTokenOp;
import com.s2u2m.mindfly.account.token.TokenProperty;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisTokenOp implements IUserTokenOp {

    TokenProperty tokenProperty;

    RedisTemplate<String, UserTokenData> redis;

    public RedisTokenOp(
            TokenProperty tokenProperty,
            RedisTemplate<String, UserTokenData> redis) {
        this.tokenProperty = tokenProperty;
        this.redis = redis;
    }

    @Override
    public String token(UserTokenData data) {
        String token = data.getInfo().getId();
        redis.opsForValue().set(token, data,
                tokenProperty.getExpireMs(), TimeUnit.MILLISECONDS);
        return token;
    }

    @Override
    public UserTokenData data(String token) {
        return redis.opsForValue().get(token);
    }
}
