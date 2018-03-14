package com.s2u2m.mindfly.account.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonPwdLoginReqDTO {
    private String loginName;
    private String password;
}
