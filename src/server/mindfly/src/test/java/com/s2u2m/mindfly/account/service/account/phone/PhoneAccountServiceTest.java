package com.s2u2m.mindfly.account.service.account.phone;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import com.s2u2m.mindfly.account.entity.PhoneAccountEntity;
import com.s2u2m.mindfly.account.mapper.PhoneAccountMapper;
import com.s2u2m.mindfly.account.service.account.phone.login.PhoneCodeLoginStrategy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class PhoneAccountServiceTest extends BaseAccountServiceTest {

    @Autowired
    PhoneAccountService phoneAccountService;

    @MockBean
    PhoneAccountMapper phoneAccountMapper;

    @MockBean
    PhoneCodeLoginStrategy phoneCodeLoginStrategy;

    @Test
    public void getLoginCode() throws Exception {
        String phone = "18615705064";
//        PhoneCodeLoginStrategy phoneCodeLoginStrategy = mock(PhoneCodeLoginStrategy.class);

        when(phoneAccountMapper.selectByPhone(anyString()))
                .thenReturn(new PhoneAccountEntity()
                        .setPhone(phone).setUserId("123456"));

        doNothing().when(phoneCodeLoginStrategy).saveLoginCode(anyString(), anyString());

        String actual = phoneAccountService.getLoginCode(phone);

        assertNotNull(actual);
    }

}