package com.s2u2m.mindfly.account.service.account;

import com.s2u2m.mindfly.account.service.user.UserInfo;

public interface ILoginStrategy<LT extends AbLoginInfo> {

    UserInfo login(LT info);
}
