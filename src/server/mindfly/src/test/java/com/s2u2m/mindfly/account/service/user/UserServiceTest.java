package com.s2u2m.mindfly.account.service.user;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseAccountServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void reg() throws Exception {
        String nickName = "hello";
        String pwd = "123";

        UserRegInfo infoEntity = new UserRegInfo();
        infoEntity.setNickName(nickName);
        infoEntity.setPassword(pwd);

        UserInfo rst = userService.reg(infoEntity);

        Assert.assertEquals(nickName, rst.getNickName());
    }

}