package com.s2u2m.mindfly.account.service.account.phone.reg;

import com.s2u2m.mindfly.account.service.account.AbRegInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PhoneCodeRegInfo extends AbRegInfo {
    private String phone;
    private String code;
}
