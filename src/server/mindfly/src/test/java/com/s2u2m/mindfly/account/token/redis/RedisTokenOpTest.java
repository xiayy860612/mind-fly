package com.s2u2m.mindfly.account.token.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.account.token.IUserTokenOp;
import com.s2u2m.mindfly.account.token.TokenProperty;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class RedisTokenOpTest extends BaseAccountServiceTest {

    @Autowired
    IUserTokenOp tokenOp;

    private String expToken = "123456";

    @Test
    public void token() throws Exception {

        UserInfoEntity info = new UserInfoEntity()
                .setId(expToken).setNickName("hello");
        UserTokenData tokenData = new UserTokenData().setInfo(info);

        String tokenActual = tokenOp.token(tokenData);

        UserTokenData rst = tokenOp.data(tokenActual);
        assertEquals(expToken, rst.getInfo().getId());
    }
}