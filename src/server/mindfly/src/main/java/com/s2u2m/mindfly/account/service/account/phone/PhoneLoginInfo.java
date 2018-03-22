package com.s2u2m.mindfly.account.service.account.phone;

import com.s2u2m.mindfly.account.service.account.AbLoginInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneLoginInfo extends AbLoginInfo {
    private String phone;
    private String password;
}
