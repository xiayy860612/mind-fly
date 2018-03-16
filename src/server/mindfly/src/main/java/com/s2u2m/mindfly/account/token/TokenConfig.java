package com.s2u2m.mindfly.account.token;

import com.s2u2m.mindfly.account.token.jwt.JwtTokenOp;
import com.s2u2m.mindfly.account.token.redis.RedisDataJsonSerializer;
import com.s2u2m.mindfly.account.token.redis.RedisTokenOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class TokenConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Autowired
    TokenProperty property;

    @Bean
    RedisTemplate<String, UserTokenData> redisTemplate() {
        RedisTemplate<String, UserTokenData> redisTemplate
                = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new RedisDataJsonSerializer());
        return redisTemplate;
    }

    @Bean
    IUserTokenOp userTokenOp() {
        RedisTokenOp tokenOp = new RedisTokenOp(property, redisTemplate());
        return tokenOp;
    }
}
