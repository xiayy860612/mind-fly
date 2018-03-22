package com.s2u2m.mindfly.account.controller.username;

import com.s2u2m.mindfly.account.controller.LoginRespDTO;
import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.service.account.username.UserNameAccountService;
import com.s2u2m.mindfly.account.service.account.username.login.UserNameLoginInfo;
import com.s2u2m.mindfly.account.service.account.username.login.UserNameLoginStrategy;
import com.s2u2m.mindfly.account.service.account.username.reg.UserNameRegInfo;
import com.s2u2m.mindfly.account.service.account.username.reg.UserNameRegStrategy;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.account.token.IUserTokenOp;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/username")
public class UserNameAccountController {

    @Autowired
    UserNameAccountService accountService;

    @Autowired
    IUserTokenOp userTokenOp;

    @Autowired
    UserNameLoginStrategy userNameLoginStrategy;

    @Autowired
    UserNameRegStrategy userNameRegStrategy;

    @PostMapping(value = "/reg")
    public LoginRespDTO reg(@RequestBody UserNameRegReqDTO data) {

        UserNameRegInfo regInfo = new UserNameRegInfo()
                .setUserName(data.getUserName())
                .setPassword(data.getPassword())
                .setPasswordConfirm(data.getPwdConfirm());
        UserInfoEntity info = accountService.reg(
                userNameRegStrategy, regInfo);

        // generate token
        UserTokenData tokenData = new UserTokenData()
                .setInfo(info);
        String token = userTokenOp.token(tokenData);

        UserInfo userInfo = new UserInfo()
                .setId(info.getId())
                .setNickName(info.getNickName());
        LoginRespDTO respDTO = new LoginRespDTO()
                .setInfo(userInfo).setToken(token);
        return respDTO;
    }

    @PostMapping(value = "/login")
    public LoginRespDTO login(@RequestBody UserNameLoginReqDTO data) {
        UserNameLoginInfo loginInfo = new UserNameLoginInfo()
                .setUserName(data.getUserName())
                .setPassword(data.getPassword());
        UserInfoEntity info = accountService.login(
                userNameLoginStrategy, loginInfo);

        // generate token
        UserTokenData tokenData = new UserTokenData()
                .setInfo(info);
        String token = userTokenOp.token(tokenData);

        UserInfo userInfo = new UserInfo()
                .setId(info.getId())
                .setNickName(info.getNickName());
        LoginRespDTO respDTO = new LoginRespDTO()
                .setInfo(userInfo).setToken(token);
        return respDTO;
    }


}
