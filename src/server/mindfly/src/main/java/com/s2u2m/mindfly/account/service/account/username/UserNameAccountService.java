package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.error.AccountErrorCode;
import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.entity.UserNameAccountEntity;
import com.s2u2m.mindfly.account.mapper.UserNameAccountEntityMapper;
import com.s2u2m.mindfly.account.service.account.IAccountManager;
import com.s2u2m.mindfly.account.service.account.ILoginStrategy;
import com.s2u2m.mindfly.account.service.user.UserInfo;
import com.s2u2m.mindfly.account.service.user.UserRegInfo;
import com.s2u2m.mindfly.account.service.user.UserService;
import com.s2u2m.mindfly.core.exception.ExceptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserNameAccountService implements
        IAccountManager<UserNameRegInfo, UserNameLoginInfo, UserNameAccountEntity> {

    @Autowired
    UserService userService;

    @Autowired
    UserNameAccountEntityMapper accountEntityMapper;

    private boolean formatOk(String userName, String password) {
        return true;
    }

    @Transactional
    @Override
    public UserInfo reg(UserNameRegInfo info) {
        // check if username and password formatOk
        if (!this.formatOk(info.getUserName(), info.getPassword())) {
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
        UserInfo userInfo = userService.reg(userRegInfo);

        // create username account and bind with related user
        accountEntity = new UserNameAccountEntity();
        accountEntity.setUserId(userInfo.getId());
        accountEntity.setUsername(info.getUserName());
        accountEntityMapper.insert(accountEntity);

        return userInfo;
    }

    @Override
    public UserInfo login(
            ILoginStrategy<UserNameLoginInfo> strategy,
            UserNameLoginInfo info) {
        return strategy.login(info);
    }

    @Override
    public void bind(UserInfoEntity entity, UserNameAccountEntity account) {

    }

    @Override
    public void reBind(UserInfoEntity entity, UserNameAccountEntity accout) {

    }

    @Override
    public void delete(UserInfoEntity entity) {

    }
}
