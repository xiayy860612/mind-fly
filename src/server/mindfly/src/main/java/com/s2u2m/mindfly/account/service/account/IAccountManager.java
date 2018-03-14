package com.s2u2m.mindfly.account.service.account;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.service.user.UserInfo;

public interface IAccountManager<
        RT extends AbRegInfo,
        LT extends AbLoginInfo,
        AT> {

    UserInfo reg(RT info);

    UserInfo login(ILoginStrategy<LT> strategy, LT info);

    void bind(UserInfoEntity entity, AT account);

    void reBind(UserInfoEntity entity, AT accout);

    void delete(UserInfoEntity entity);
}
