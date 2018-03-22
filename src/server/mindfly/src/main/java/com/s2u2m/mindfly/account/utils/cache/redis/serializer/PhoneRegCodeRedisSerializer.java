package com.s2u2m.mindfly.account.utils.cache.redis.serializer;

import com.s2u2m.mindfly.account.service.account.phone.reg.PhoneCodeRegInfo;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class PhoneRegCodeRedisSerializer implements RedisSerializer<PhoneCodeRegInfo> {

    @Override
    public byte[] serialize(PhoneCodeRegInfo phoneCodeRegInfo) throws SerializationException {
        return new byte[0];
    }

    @Override
    public PhoneCodeRegInfo deserialize(byte[] bytes) throws SerializationException {
        return null;
    }
}
