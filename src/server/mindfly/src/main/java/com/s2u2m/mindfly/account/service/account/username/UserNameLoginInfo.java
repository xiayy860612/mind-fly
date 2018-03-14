package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.service.account.AbLoginInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserNameLoginInfo extends AbLoginInfo {
    private String userName;
    private String password;
}
