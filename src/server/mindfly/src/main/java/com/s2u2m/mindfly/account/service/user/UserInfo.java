package com.s2u2m.mindfly.account.service.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserInfo {
    private String id;
    private String nickName;
}
