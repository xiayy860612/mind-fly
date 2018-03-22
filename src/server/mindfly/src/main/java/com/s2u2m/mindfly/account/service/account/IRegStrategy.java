package com.s2u2m.mindfly.account.service.account;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;

public interface IRegStrategy<RT extends AbRegInfo> {
    UserInfoEntity reg(RT info);
}
