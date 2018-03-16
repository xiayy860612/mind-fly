package com.s2u2m.mindfly.account.service.account;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;

public interface ILoginStrategy<LT extends AbLoginInfo> {

    UserInfoEntity login(LT info);
}
