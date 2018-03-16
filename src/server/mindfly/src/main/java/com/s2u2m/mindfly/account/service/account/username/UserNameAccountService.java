package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.entity.UserNameAccountEntity;
import com.s2u2m.mindfly.account.mapper.UserNameAccountEntityMapper;
import com.s2u2m.mindfly.account.service.account.*;
import com.s2u2m.mindfly.account.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserNameAccountService implements
        IAccountManager<UserNameAccountEntity> {

    @Autowired
    UserService userService;

    @Autowired
    UserNameAccountEntityMapper accountEntityMapper;

    @Autowired
    UserNameFormatChecker userNameFormatChecker;

    @Autowired
    PasswordFormatChecker passwordFormatChecker;

    @Transactional
    @Override
    public void bind(UserInfoEntity entity, UserNameAccountEntity account) {

    }

    @Transactional
    @Override
    public void reBind(UserInfoEntity entity, UserNameAccountEntity accout) {

    }

    @Transactional
    @Override
    public <RT extends AbRegInfo> UserInfoEntity reg(
            IRegStrategy<RT> strategy, RT info) {
        return strategy.reg(info);
    }

    @Transactional(readOnly = true)
    @Override
    public <LT extends AbLoginInfo> UserInfoEntity login(
            ILoginStrategy<LT> strategy, LT info) {
        return strategy.login(info);
    }

    @Transactional
    @Override
    public void delete(UserInfoEntity entity) {

    }
}
