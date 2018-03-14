package com.s2u2m.mindfly.account.controller.username;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import com.s2u2m.mindfly.account.controller.LoginRespDTO;
import com.s2u2m.mindfly.account.service.account.username.UserNameAccountService;
import com.s2u2m.mindfly.account.service.account.username.UserNameRegInfo;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.account.token.IUserTokenOp;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserNameAccountControllerTest extends BaseAccountServiceTest {

    @Autowired
    private UserNameAccountService accountService;

    @MockBean
    private IUserTokenOp userTokenOp;

    @Test
    public void reg() throws Exception {
        String userName = "hello";
        String pwd = "123456";

        UserInfo expected = new UserInfo();
        expected.setId("1");
        expected.setNickName(userName);

        String token = "sadf";
        when(userTokenOp.token(any(UserTokenData.class))).thenReturn(token);

        // execute
        UserNameRegReqDTO reqDTO = new UserNameRegReqDTO()
                .setUserName(userName)
                .setPassword(pwd).setPwdConfirm(pwd);
        ObjectMapper mapper = new ObjectMapper();

        MvcResult result = mockMvc.perform(post("/account/reg")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(reqDTO))
        ).andExpect(status().isOk()).andReturn();

        LoginRespDTO respDTO = mapper.readValue(
                result.getResponse().getContentAsString(), LoginRespDTO.class);

        Assert.assertEquals(token, respDTO.getToken());
        Assert.assertEquals(userName, respDTO.getInfo().getNickName());
    }

    @Ignore
    @Test
    public void login() throws Exception {
        String userName = "hello";
        String pwd = "123456";
        UserNameLoginReqDTO reqDTO = new UserNameLoginReqDTO()
                .userName(userName).password(pwd);

        RequestBuilder builder = post("/account/log")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonSerializer.writeValueAsString(reqDTO));

        MvcResult rst = mockMvc.perform(builder)
                .andExpect(status().isOk()).andReturn();

        LoginRespDTO respDTO = jsonSerializer.readValue(
                rst.getResponse().getContentAsString(), LoginRespDTO.class);

        Assert.assertTrue(!respDTO.getToken().isEmpty());
    }

}