package com.s2u2m.mindfly.account.utils.cache.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s2u2m.mindfly.account.utils.cache.ICache;
import com.s2u2m.mindfly.core.exception.ExceptionBuilder;
import com.s2u2m.mindfly.core.exception.error.FrameworkErrorCode;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RedisCache<VT> implements ICache<String, VT> {

    RedisTemplate<String, String> redisTemplate;

    public RedisCache(RedisTemplate<String, String> template) {
        this.redisTemplate = template;
    }

    @Override
    public void set(String key, VT value, long expireMs) {
        ObjectMapper mapper = new ObjectMapper();
        String rv;
        try {
            rv = mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw ExceptionBuilder.build(
                    FrameworkErrorCode.ComponentError,
                    e.getMessage());
        }

        redisTemplate.opsForValue().set(key, rv, expireMs, TimeUnit.MILLISECONDS);
    }

    @Override
    public VT get(String key, Class<VT> vtClass) {
        String rv = redisTemplate.opsForValue().get(key);
        if (rv == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            VT value = mapper.readValue(rv, vtClass);
            return value;
        } catch (IOException e) {
            e.printStackTrace();
            throw ExceptionBuilder.build(
                    FrameworkErrorCode.ComponentError,
                    e.getMessage());
        }
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }
}
