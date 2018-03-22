package com.s2u2m.mindfly.account.controller.username;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserNameRegReqDTO {
    private String userName;
    private String password;
    private String pwdConfirm;
}
