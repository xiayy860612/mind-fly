package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.service.account.AbRegInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserNameRegInfo extends AbRegInfo {
    private String userName;
    private String password;
    private String passwordConfirm;


}
