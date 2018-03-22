package com.s2u2m.mindfly.account.controller.phone;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import com.s2u2m.mindfly.account.controller.LoginRespDTO;
import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.service.account.phone.PhoneAccountService;
import com.s2u2m.mindfly.account.service.account.phone.reg.PhoneCodeRegInfo;
import com.s2u2m.mindfly.account.service.account.phone.reg.PhoneCodeRegStrategy;
import com.s2u2m.mindfly.account.token.IUserTokenOp;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class PhoneAccountControllerTest extends BaseAccountServiceTest {

    @MockBean
    PhoneAccountService phoneAccountService;

    @MockBean
    IUserTokenOp userTokenOp;

    @Autowired
    PhoneCodeRegStrategy phoneCodeRegStrategy;

    @Test
    public void getRegCode() throws Exception {
        String code = "123456";
        when(phoneAccountService.getRegCode(anyString())).thenReturn(code);

        PhoneCodeRespDTO respDTO = httpGet(
                "/phone/18615705064/reg/code", PhoneCodeRespDTO.class);

        assertEquals(code, respDTO.getCode());
    }

    @Test
    public void reg() throws Exception {
        String code = "123456";
        String phone = "18615705064";
        String id = "123";
        String nickName = "hello";
        String token = "123456";
        when(phoneAccountService.reg(
                any(PhoneCodeRegStrategy.class),
                any(PhoneCodeRegInfo.class)))
                .thenReturn(new UserInfoEntity()
                        .setId(id).setNickName(nickName));

        when(userTokenOp.token(any(UserTokenData.class))).thenReturn(token);


        PhoneRegReqDTO data = new PhoneRegReqDTO()
                .setCode(code).setPhone(phone);
        LoginRespDTO respDTO = httpPost("/phone/reg/code", data, LoginRespDTO.class);

        assertTrue(token.equals(respDTO.getToken()));
        assertTrue(id.equals(respDTO.getInfo().getId()));
        assertTrue(nickName.equals(respDTO.getInfo().getNickName()));
    }

    @Test
    public void getLoginCode() throws Exception {
        String code = "123456";

        when(phoneAccountService.getLoginCode(anyString()))
                .thenReturn(code);

        PhoneCodeRespDTO respDTO = httpGet(
                "/phone/18615705064/login/code", PhoneCodeRespDTO.class);

        assertTrue(code.equals(respDTO.getCode()));
    }

}