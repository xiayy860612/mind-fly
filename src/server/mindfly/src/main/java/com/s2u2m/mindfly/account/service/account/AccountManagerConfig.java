package com.s2u2m.mindfly.account.service.account;

import com.s2u2m.mindfly.account.mapper.PhoneAccountMapper;
import com.s2u2m.mindfly.account.mapper.UserInfoEntityMapper;
import com.s2u2m.mindfly.account.mapper.UserNameAccountEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountManagerConfig {

    @Autowired
    UserInfoEntityMapper userMapper;

    @Autowired
    UserNameAccountEntityMapper userNameAccountEntityMapper;



    @Autowired
    PhoneAccountMapper phoneAccountMapper;

}
