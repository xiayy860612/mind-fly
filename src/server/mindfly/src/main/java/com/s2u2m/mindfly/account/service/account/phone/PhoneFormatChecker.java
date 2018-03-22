package com.s2u2m.mindfly.account.service.account.phone;

import com.s2u2m.mindfly.account.utils.formatchecker.IFormatChecker;
import org.springframework.stereotype.Component;

@Component
public class PhoneFormatChecker implements IFormatChecker<String> {

    @Override
    public boolean check(String data) {
        return true;
    }
}
