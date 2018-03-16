package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.entity.UserNameAccountEntity;
import com.s2u2m.mindfly.account.mapper.UserInfoEntityMapper;
import com.s2u2m.mindfly.account.mapper.UserNameAccountEntityMapper;
import com.s2u2m.mindfly.account.service.account.username.login.UserNameLoginInfo;
import com.s2u2m.mindfly.account.service.account.username.login.UserNameLoginStrategy;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class UserNameLoginStratetyTest extends BaseAccountServiceTest {

    @Autowired
    UserNameLoginStrategy loginStratety;

    @MockBean
    UserNameAccountEntityMapper accountEntityMapper;

    @MockBean
    UserInfoEntityMapper userInfoEntityMapper;

    @Test
    public void login() throws Exception {
        String id = "123456";
        String userName = "xiayy860612";
        String password = "123456";
        UserNameLoginInfo loginInfo = new UserNameLoginInfo()
                .setUserName(userName)
                .setPassword(password);

        when(accountEntityMapper.selectByUserName(anyString()))
                .thenReturn(new UserNameAccountEntity()
                        .setUserId(id).setUsername(userName));
        when(userInfoEntityMapper.selectById(anyString()))
                .thenReturn(new UserInfoEntity()
                        .setId(id).setNickName(userName).setPassword(password));

        UserInfoEntity info = loginStratety.login(loginInfo);

        Assert.assertEquals(userName, info.getNickName());
    }

}