package com.s2u2m.mindfly.account.service.account.phone.reg;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.service.user.UserRegInfo;
import com.s2u2m.mindfly.account.service.user.UserService;
import com.s2u2m.mindfly.account.utils.cache.redis.RedisCache;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class PhoneCodeRegStrategyTest extends BaseAccountServiceTest {

    @Autowired
    PhoneCodeRegStrategy regStrategy;

    @MockBean
    RedisCache<String> phoneCodeRegInfoRedisCache;

    @MockBean
    UserService userService;

    @Test
    public void reg() throws Exception {
        String code = "123456";
        String id = "123456";

        when(phoneCodeRegInfoRedisCache.get(anyString(), any()))
                .thenReturn(code);
        when(userService.reg(any(UserRegInfo.class)))
                .thenReturn(new UserInfoEntity().setId(id));

        PhoneCodeRegInfo regInfo = new PhoneCodeRegInfo()
                .setCode(code)
                .setPhone("18615705064");
        UserInfoEntity actual = regStrategy.reg(regInfo);

        assertTrue(id.equals(actual.getId()));
    }

}