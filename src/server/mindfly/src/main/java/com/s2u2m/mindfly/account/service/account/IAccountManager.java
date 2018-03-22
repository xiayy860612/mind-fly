package com.s2u2m.mindfly.account.service.account;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.service.user.UserInfo;

public interface IAccountManager<AT> {

    <RT extends AbRegInfo> UserInfoEntity reg(IRegStrategy<RT> strategy, RT info);

    <LT extends AbLoginInfo> UserInfoEntity login(ILoginStrategy<LT> strategy, LT info);

    void bind(UserInfoEntity entity, AT account);

    void reBind(UserInfoEntity entity, AT accout);

    void delete(UserInfoEntity entity);
}
