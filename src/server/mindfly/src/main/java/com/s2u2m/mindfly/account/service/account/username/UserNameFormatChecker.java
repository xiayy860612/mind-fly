package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.service.account.IFormatChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNameFormatChecker implements IFormatChecker<String> {

    @Autowired
    UserNameAccountProperty accountProperty;

    private static final String pattern = "^[a-zA-Z]\\w+$";

    @Override
    public boolean check(String data) {
        if ( data.length() < accountProperty.getUsernameMinLen()
                || data.length() > accountProperty.getUsernameMaxLen()) {
            return false;
        }

        return data.matches(pattern);
    }
}