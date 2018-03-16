package com.s2u2m.mindfly.account.service.account.username.login;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.entity.UserNameAccountEntity;
import com.s2u2m.mindfly.account.error.AccountErrorCode;
import com.s2u2m.mindfly.account.mapper.UserInfoEntityMapper;
import com.s2u2m.mindfly.account.mapper.UserNameAccountEntityMapper;
import com.s2u2m.mindfly.account.service.account.ILoginStrategy;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.core.exception.ExceptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNameLoginStrategy implements ILoginStrategy<UserNameLoginInfo> {

    @Autowired
    UserNameAccountEntityMapper accountEntityMapper;

    @Autowired
    UserInfoEntityMapper userInfoEntityMapper;

    @Override
    public UserInfoEntity login(UserNameLoginInfo info) {
        UserNameAccountEntity account = accountEntityMapper
                .selectByUserName(info.getUserName());
        if (account == null) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.UserNameNotExisted,
                    String.format("Username[%s] not existed", info.getUserName()));
        }

        UserInfoEntity userInfoEntity = userInfoEntityMapper
                .selectById(account.getUserId());

        if (!info.getPassword().equals(userInfoEntity.getPassword())) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.LoginPasswordIncorrect,
                    "password incorrect");
        }

        return userInfoEntity;
    }
}
