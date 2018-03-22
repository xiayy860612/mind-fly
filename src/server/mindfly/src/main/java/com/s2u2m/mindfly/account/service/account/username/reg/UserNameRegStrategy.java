package com.s2u2m.mindfly.account.service.account.username.reg;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.entity.UserNameAccountEntity;
import com.s2u2m.mindfly.account.error.AccountErrorCode;
import com.s2u2m.mindfly.account.mapper.UserNameAccountEntityMapper;
import com.s2u2m.mindfly.account.service.account.IRegStrategy;
import com.s2u2m.mindfly.account.service.account.username.PasswordFormatChecker;
import com.s2u2m.mindfly.account.service.account.username.UserNameFormatChecker;
import com.s2u2m.mindfly.account.service.user.UserRegInfo;
import com.s2u2m.mindfly.account.service.user.UserService;
import com.s2u2m.mindfly.core.exception.ExceptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNameRegStrategy implements IRegStrategy<UserNameRegInfo> {

    @Autowired
    UserService userService;

    @Autowired
    UserNameAccountEntityMapper accountEntityMapper;

    @Autowired
    UserNameFormatChecker userNameFormatChecker;

    @Autowired
    PasswordFormatChecker passwordFormatChecker;

    @Override
    public UserInfoEntity reg(UserNameRegInfo info) {
        // check if account and password formatOk
        if (!userNameFormatChecker.check(info.getUserName())
                || !passwordFormatChecker.check(info.getPassword())) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.UserNameOrPasswordInvalid,
                    "UserName or Password invalid");
        }

        if (!info.getPassword().equals(info.getPasswordConfirm())) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.UserNameAccountRegPwdNotMatched,
                    "password and confirm not matched");
        }

        UserNameAccountEntity accountEntity = accountEntityMapper
                .selectByUserName(info.getUserName());
        if (accountEntity != null) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.UserNameAccountAlreadyExisted,
                    String.format("UserName[%s] already existed", info.getUserName()));
        }

        // create user info
        UserRegInfo userRegInfo = new UserRegInfo();
        userRegInfo.setNickName(info.getUserName());
        userRegInfo.setPassword(info.getPassword());
        UserInfoEntity userInfoEntity = userService.reg(userRegInfo);

        // create account account and bind with related user
        accountEntity = new UserNameAccountEntity();
        accountEntity.setUserId(userInfoEntity.getId());
        accountEntity.setUsername(info.getUserName());
        accountEntityMapper.insert(accountEntity);

        return userInfoEntity;
    }
}
