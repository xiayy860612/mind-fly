package com.s2u2m.mindfly.account.controller.username;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import com.s2u2m.mindfly.account.controller.LoginRespDTO;
import com.s2u2m.mindfly.account.service.account.ILoginStrategy;
import com.s2u2m.mindfly.account.service.account.username.UserNameAccountService;
import com.s2u2m.mindfly.account.service.account.username.UserNameLoginInfo;
import com.s2u2m.mindfly.account.service.account.username.UserNameLoginStratety;
import com.s2u2m.mindfly.account.service.account.username.UserNameRegInfo;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.account.token.IUserTokenOp;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
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

    @MockBean
    private UserNameAccountService accountService;

    @MockBean
    private IUserTokenOp userTokenOp;

    @Test
    public void reg() throws Exception {
        String id = "123456";
        String userName = "xiayy860612";
        String pwd = "xiayy@123456";

        UserInfo expected = new UserInfo();
        expected.setId(id);
        expected.setNickName(userName);
        when(accountService.reg(any(UserNameRegInfo.class)))
                .thenReturn(expected);
        when(userTokenOp.token(any(UserTokenData.class)))
                .thenReturn(id);

        // execute
        UserNameRegReqDTO reqDTO = new UserNameRegReqDTO()
                .setUserName(userName)
                .setPassword(pwd).setPwdConfirm(pwd);
        ObjectMapper mapper = new ObjectMapper();

        MvcResult result = mockMvc.perform(post("/username/reg")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(reqDTO))
        ).andExpect(status().isOk()).andReturn();

        LoginRespDTO respDTO = mapper.readValue(
                result.getResponse().getContentAsString(), LoginRespDTO.class);

        Assert.assertEquals(id, respDTO.getToken());
        Assert.assertEquals(userName, respDTO.getInfo().getNickName());
    }

    @Test
    public void login() throws Exception {
        String id = "123456";
        String userName = "hello";
        String pwd = "123456";

        when(accountService.login(any(UserNameLoginStratety.class), any(UserNameLoginInfo.class)))
                .thenReturn(new UserInfo().setId(id).setNickName(userName));
        when(userTokenOp.token(any(UserTokenData.class)))
                .thenReturn(id);

        UserNameLoginReqDTO reqDTO = new UserNameLoginReqDTO()
                .setUserName(userName).setPassword(pwd);

        ObjectMapper mapper = new ObjectMapper();
        RequestBuilder builder = post("/username/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonSerializer.writeValueAsString(reqDTO));

        MvcResult rst = mockMvc.perform(builder)
                .andExpect(status().isOk()).andReturn();

        LoginRespDTO respDTO = jsonSerializer.readValue(
                rst.getResponse().getContentAsString(), LoginRespDTO.class);

        Assert.assertEquals(id, respDTO.getToken());
        Assert.assertEquals(userName, respDTO.getInfo().getNickName());
    }

}