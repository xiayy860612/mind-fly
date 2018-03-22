package com.s2u2m.mindfly.account.token;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.core.token.AbTokenData;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserTokenData extends AbTokenData {
    private UserInfoEntity info;
}
