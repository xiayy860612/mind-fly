package com.s2u2m.mindfly.account.service.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserRegInfo {
    private String nickName;
    private String password;
}
