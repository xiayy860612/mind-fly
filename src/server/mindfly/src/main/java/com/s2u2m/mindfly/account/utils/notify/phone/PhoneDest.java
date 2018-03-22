package com.s2u2m.mindfly.account.utils.notify.phone;

import com.s2u2m.mindfly.account.utils.notify.AbNotifyDest;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PhoneDest extends AbNotifyDest {
    private String phone;
}
