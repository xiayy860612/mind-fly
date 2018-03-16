package com.s2u2m.mindfly.account.token.redis;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.account.token.TokenProperty;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import static org.junit.Assert.*;

public class RedisTokenOpTest extends BaseAccountServiceTest {

    @Autowired
    TokenProperty property;

    @Autowired
    RedisTemplate<String, UserTokenData> redisTemplate;

    private RedisTokenOp tokenOp;

    private String expToken = "123456";

    @Before
    public void setUp() {
        tokenOp = new RedisTokenOp(property, redisTemplate);
    }

    @Test
    public void token() throws Exception {

        UserInfo info = new UserInfo().setId(expToken).setNickName("hello");
        UserTokenData tokenData = new UserTokenData().setInfo(info);

        String tokenActual = tokenOp.token(tokenData);

        assertEquals(expToken, tokenActual);

        UserTokenData rst = tokenOp.data(expToken);
        assertEquals(expToken, rst.getInfo().getId());
    }

}