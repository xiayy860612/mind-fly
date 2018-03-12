package com.s2u2m.mindfly.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonAccountRegReqDTO {
    private String userName;
    private String email;
    private String password;
    private String pwdConfirm;
}
