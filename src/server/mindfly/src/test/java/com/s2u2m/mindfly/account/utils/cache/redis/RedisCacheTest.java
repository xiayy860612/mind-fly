package com.s2u2m.mindfly.account.utils.cache.redis;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.Assert.*;

public class RedisCacheTest extends BaseAccountServiceTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    RedisCache<RedisData> redisCache;

    @Before
    public void setUp() {
        redisCache = new RedisCache<>(redisTemplate);
    }

    @Test
    public void testRedis() {
        String key = "123456";
        RedisData data = new RedisData()
                .setId(1).setName("hello");
        redisCache.set(key, data, 60000);

        RedisData actual = redisCache.get(key, RedisData.class);
        assertEquals(data.getId(), actual.getId());

        redisCache.del(key);
        actual = redisCache.get(key, RedisData.class);
        assertNull(actual);
    }

}