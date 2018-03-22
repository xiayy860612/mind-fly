package com.s2u2m.mindfly.account.service.account.phone.login;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.service.account.ILoginStrategy;
import org.springframework.stereotype.Component;

@Component
public class PhoneCodeLoginStrategy implements ILoginStrategy<PhoneCodeLoginInfo> {

    public void saveLoginCode(String phone, String code) {

    }

    @Override
    public UserInfoEntity login(PhoneCodeLoginInfo info) {
        return null;
    }
}
