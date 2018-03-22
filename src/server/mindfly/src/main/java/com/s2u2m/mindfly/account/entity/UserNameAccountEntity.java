package com.s2u2m.mindfly.account.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserNameAccountEntity {
    private String userId;
    private String username;
}
