package com.s2u2m.mindfly.account.controller.username;

import com.s2u2m.mindfly.account.controller.LoginRespDTO;
import com.s2u2m.mindfly.account.service.account.ILoginStrategy;
import com.s2u2m.mindfly.account.service.account.username.UserNameAccountService;
import com.s2u2m.mindfly.account.service.account.username.UserNameLoginInfo;
import com.s2u2m.mindfly.account.service.account.username.UserNameLoginStratety;
import com.s2u2m.mindfly.account.service.account.username.UserNameRegInfo;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.account.token.IUserTokenOp;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class UserNameAccountController {

    @Autowired
    UserNameAccountService accountService;

    @Autowired
    IUserTokenOp userTokenOp;

    @PostMapping(value = "/reg")
    public LoginRespDTO reg(@RequestBody UserNameRegReqDTO data) {

        UserNameRegInfo regInfo = new UserNameRegInfo()
                .setUserName(data.getUserName())
                .setPassword(data.getPassword())
                .setPasswordConfirm(data.getPwdConfirm());
        UserInfo info = accountService.reg(regInfo);

        // generate token
        UserTokenData tokenData = new UserTokenData();
        String token = userTokenOp.token(tokenData);

        LoginRespDTO respDTO = new LoginRespDTO()
                .setInfo(info).setToken(token);
        return respDTO;
    }

    @PostMapping(value = "/login")
    public LoginRespDTO login(@RequestBody UserNameLoginReqDTO data) {
        ILoginStrategy<UserNameLoginInfo> strategy = new UserNameLoginStratety();
        UserNameLoginInfo loginInfo = new UserNameLoginInfo()
                .setUserName(data.userName())
                .setPassword(data.password());
        UserInfo info = accountService.login(strategy, loginInfo);

        // generate token
        UserTokenData tokenData = new UserTokenData();
        String token = userTokenOp.token(tokenData);

        LoginRespDTO respDTO = new LoginRespDTO().setInfo(info).setToken(token);
        return respDTO;
    }


}
