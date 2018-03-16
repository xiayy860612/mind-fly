package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import com.s2u2m.mindfly.account.mapper.UserNameAccountEntityMapper;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.account.service.user.UserRegInfo;
import com.s2u2m.mindfly.account.service.user.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class UserNameAccountServiceTest extends BaseAccountServiceTest {

    @MockBean
    UserService userService;

    @MockBean
    UserNameAccountEntityMapper accountEntityMapper;

    @Autowired
    UserNameAccountService accountService;

    @Test
    public void reg() throws Exception {
        String id = "1";
        String userName = "xiayy860612";
        String pwd = "xiayy@123456";

        when(userService.reg(any(UserRegInfo.class)))
                .thenReturn(new UserInfo().setId(id).setNickName(userName));
        when(accountEntityMapper.selectByUserName(anyString()))
                .thenReturn(null);

        UserNameRegInfo regInfo = new UserNameRegInfo()
                .setUserName(userName)
                .setPassword(pwd)
                .setPasswordConfirm(pwd);
        UserInfo rst = accountService.reg(regInfo);

        Assert.assertEquals(id, rst.getId());
        Assert.assertEquals(userName, rst.getNickName());
    }

    @Test
    public void login() throws Exception {
    }

    @Test
    public void bind() throws Exception {
    }

    @Test
    public void reBind() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}