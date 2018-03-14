package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.service.account.IFormatChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordFormatChecker implements IFormatChecker<String> {

    @Autowired
    UserNameAccountProperty accountProperty;

    private static final String specialChars = "!@#$%^&*()-+=";

    @Override
    public boolean check(String data) {
        if (data.length() < accountProperty.getPasswordMinLen()
                || data.length() > accountProperty.getPasswordMaxLen()) {
            return false;
        }

        String pwdPattern = String.format(
                "^[a-zA-Z]\\w+[%s]+[\\w%s]*", specialChars, specialChars);
        return data.matches(pwdPattern);
    }
}
