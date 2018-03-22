package com.s2u2m.mindfly.account.controller.phone;

import com.s2u2m.mindfly.account.controller.LoginRespDTO;
import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.service.account.phone.PhoneAccountService;
import com.s2u2m.mindfly.account.service.account.phone.reg.PhoneCodeRegInfo;
import com.s2u2m.mindfly.account.service.account.phone.reg.PhoneCodeRegStrategy;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.account.token.IUserTokenOp;
import com.s2u2m.mindfly.account.token.UserTokenData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/phone")
public class PhoneAccountController {

    @Autowired
    PhoneAccountService phoneAccountService;

    @Autowired
    PhoneCodeRegStrategy phoneCodeRegStrategy;

    @Autowired
    IUserTokenOp userTokenOp;

    @GetMapping(value = "/{phone}/reg/code")
    public PhoneCodeRespDTO getRegCode(@PathVariable String phone) {
        String code = phoneAccountService.getRegCode(phone);
        return new PhoneCodeRespDTO().setCode(code);
    }

    @PostMapping(value = "/reg/code")
    public LoginRespDTO reg(@RequestBody PhoneRegReqDTO data) {
        UserInfoEntity entity = phoneAccountService.reg(phoneCodeRegStrategy,
                new PhoneCodeRegInfo()
                        .setPhone(data.getPhone())
                        .setCode(data.getCode()));

        UserTokenData tokenData = new UserTokenData()
                .setInfo(entity);
        String token = userTokenOp.token(tokenData);

        UserInfo userInfo = new UserInfo()
                .setId(entity.getId())
                .setNickName(entity.getNickName());
        LoginRespDTO respDTO = new LoginRespDTO()
                .setInfo(userInfo).setToken(token);

        return respDTO;
    }

    @GetMapping(value = "/{phone}/login/code")
    public PhoneCodeRespDTO getLoginCode(@PathVariable String phone) {
        String code = phoneAccountService.getLoginCode(phone);
        return new PhoneCodeRespDTO().setCode(code);
    }

    @PostMapping(value = "/login")
    public LoginRespDTO login(@RequestBody PhoneLoginReqDTO data) {

        String token = "";

        UserInfo userInfo = new UserInfo();
        return new LoginRespDTO().setToken(token).setInfo(userInfo);
    }
}
