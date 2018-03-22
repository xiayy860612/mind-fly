package com.s2u2m.mindfly.account.utils.notify.phone.events;

import com.s2u2m.mindfly.account.utils.notify.AbNotifyParam;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AccountRegCodeNotifyParam extends AbNotifyParam {
    private String code;
}
