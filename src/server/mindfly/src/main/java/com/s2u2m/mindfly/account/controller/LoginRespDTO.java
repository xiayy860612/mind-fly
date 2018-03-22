package com.s2u2m.mindfly.account.controller;

import com.s2u2m.mindfly.account.service.user.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class LoginRespDTO {
    private String token;
    private UserInfo info;
}
