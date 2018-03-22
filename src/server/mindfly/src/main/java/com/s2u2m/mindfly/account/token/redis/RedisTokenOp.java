package com.s2u2m.mindfly.account.token.redis;

import com.s2u2m.mindfly.account.token.IUserTokenOp;
import com.s2u2m.mindfly.account.token.TokenProperty;
import com.s2u2m.mindfly.account.token.UserTokenData;
import com.s2u2m.mindfly.account.utils.cache.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RedisTokenOp implements IUserTokenOp {

    TokenProperty tokenProperty;

    @Autowired
    RedisCache<UserTokenData> redisCache;

    public RedisTokenOp(
            TokenProperty tokenProperty) {
        this.tokenProperty = tokenProperty;
    }

    private String key(String token) {
        return String.join(":", tokenProperty.getKey(), token);
    }

    @Override
    public String token(UserTokenData data) {
        String token = UUID.randomUUID().toString();
        redisCache.set(key(token), data, tokenProperty.getExpireMs());
        return token;
    }

    @Override
    public UserTokenData data(String token) {
        return redisCache.get(key(token), UserTokenData.class);
    }
}
