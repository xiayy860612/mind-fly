package com.s2u2m.mindfly.account.config;

import com.s2u2m.mindfly.account.service.account.phone.reg.PhoneCodeRegInfo;
import com.s2u2m.mindfly.account.token.UserTokenData;
import com.s2u2m.mindfly.account.utils.cache.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class CacheConfig {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Bean
    RedisCache<UserTokenData> userTokenDataRedisCache() {
        return new RedisCache<>(redisTemplate);
    }

    @Bean
    RedisCache<PhoneCodeRegInfo> phoneCodeRegInfoRedisCache() {
        return new RedisCache<>(redisTemplate);
    }

    @Bean
    RedisCache<String> stringRedisCache() {
        return new RedisCache<>(redisTemplate);
    }

}
