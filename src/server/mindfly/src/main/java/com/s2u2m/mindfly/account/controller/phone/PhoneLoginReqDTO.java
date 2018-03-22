package com.s2u2m.mindfly.account.controller.phone;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PhoneLoginReqDTO {
    private String phone;
    private String code;
}
