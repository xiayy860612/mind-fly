package com.s2u2m.mindfly.account.utils.cache.redis.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UserTokenDataRedisSerializer implements RedisSerializer<UserTokenData> {

    @Override
    public byte[] serialize(UserTokenData dt) throws SerializationException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(outputStream, dt);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SerializationException("serialize UserTokenData failed");
        }
        return outputStream.toByteArray();
    }

    @Override
    public UserTokenData deserialize(byte[] bytes) throws SerializationException {
        ObjectMapper mapper = new ObjectMapper();
        UserTokenData data = null;
        try {
            data = mapper.readValue(bytes, UserTokenData.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SerializationException("deserialize UserTokenData failed");
        }
        return data;
    }
}
