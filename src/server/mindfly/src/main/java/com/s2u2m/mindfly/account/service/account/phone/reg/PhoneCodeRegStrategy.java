package com.s2u2m.mindfly.account.service.account.phone.reg;

import com.s2u2m.mindfly.account.entity.PhoneAccountEntity;
import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.error.AccountErrorCode;
import com.s2u2m.mindfly.account.mapper.PhoneAccountMapper;
import com.s2u2m.mindfly.account.service.account.AccountConfigProperty;
import com.s2u2m.mindfly.account.service.account.IRegStrategy;
import com.s2u2m.mindfly.account.service.user.UserRegInfo;
import com.s2u2m.mindfly.account.service.user.UserService;
import com.s2u2m.mindfly.account.utils.cache.redis.RedisCache;
import com.s2u2m.mindfly.core.exception.ExceptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneCodeRegStrategy implements IRegStrategy<PhoneCodeRegInfo> {

    @Autowired
    AccountConfigProperty accountProperty;

    @Autowired
    RedisCache<String> phoneCodeRegInfoRedisCache;

    @Autowired
    UserService userService;

    @Autowired
    PhoneAccountMapper phoneAccountMapper;

    private String key(String value) {
        return String.join(":", "phone:reg:code", value);
    }

    public void saveRegCode(String phone, String code) {
        phoneCodeRegInfoRedisCache.set(key(phone), code,
                accountProperty.getPhoneCodeExpire());
    }

    @Override
    public UserInfoEntity reg(PhoneCodeRegInfo info) {
        String code = phoneCodeRegInfoRedisCache.get(
                key(info.getPhone()), String.class);
        if (code == null) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.PhoneRegCodeNotExisted,
                    String.format("no reg code for %s", info.getPhone()));
        }

        if (!code.equals(info.getCode())) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.PhoneRegCodeNotMatched,
                    "reg code not matched");
        }

        UserRegInfo userRegInfo = new UserRegInfo()
                .setNickName(info.getPhone())
                .setPassword("");
        UserInfoEntity entity = userService.reg(userRegInfo);

        PhoneAccountEntity accountEntity = new PhoneAccountEntity()
                .setUserId(entity.getId())
                .setPhone(info.getPhone());
        phoneAccountMapper.insert(accountEntity);

        phoneCodeRegInfoRedisCache.del(key(info.getPhone()));

        return entity;
    }
}
