package com.s2u2m.mindfly.account.controller.username;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserNameLoginReqDTO {
    private String userName;
    private String password;
}
