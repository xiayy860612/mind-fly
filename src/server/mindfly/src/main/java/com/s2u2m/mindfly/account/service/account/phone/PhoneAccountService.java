package com.s2u2m.mindfly.account.service.account.phone;

import com.s2u2m.mindfly.account.entity.PhoneAccountEntity;
import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.error.AccountErrorCode;
import com.s2u2m.mindfly.account.mapper.PhoneAccountMapper;
import com.s2u2m.mindfly.account.service.account.*;
import com.s2u2m.mindfly.account.service.account.phone.login.PhoneCodeLoginStrategy;
import com.s2u2m.mindfly.account.service.account.phone.reg.PhoneCodeRegStrategy;
import com.s2u2m.mindfly.account.utils.notify.phone.PhoneDest;
import com.s2u2m.mindfly.account.utils.notify.phone.events.AccountLoginCodeNotifyParam;
import com.s2u2m.mindfly.account.utils.notify.phone.events.AccountLoginCodePhoneNotify;
import com.s2u2m.mindfly.account.utils.notify.phone.events.AccountRegCodeNotifyParam;
import com.s2u2m.mindfly.account.utils.notify.phone.events.AccountRegCodePhoneNotify;
import com.s2u2m.mindfly.account.utils.random.RandomUtil;
import com.s2u2m.mindfly.core.exception.ExceptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhoneAccountService implements IAccountManager<PhoneAccountEntity> {

    @Autowired
    PhoneAccountMapper phoneAccountMapper;

    @Autowired
    PhoneFormatChecker phoneFormatChecker;

    @Autowired
    PhoneCodeRegStrategy phoneCodeRegStrategy;

    @Autowired
    PhoneCodeLoginStrategy phoneCodeLoginStrategy;

    @Transactional(readOnly = true)
    public String getRegCode(String phone) {
        if (!phoneFormatChecker.check(phone)) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.PhoneInvalid,
                    String.format("%s is invalid", phone));
        }

        PhoneAccountEntity entity = phoneAccountMapper.selectByPhone(phone);
        if (entity != null) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.PhoneAccountAlreadyExisted,
                    String.format("%s already existed", phone));
        }

        String code = RandomUtil.nextString(6);
        new AccountRegCodePhoneNotify().notify(
                new PhoneDest().setPhone(phone),
                new AccountRegCodeNotifyParam().setCode(code)
        );

        phoneCodeRegStrategy.saveRegCode(phone, code);
        return code;
    }

    @Transactional(readOnly = true)
    public String getLoginCode(String phone) {
        if (!phoneFormatChecker.check(phone)) {
            throw ExceptionBuilder.build(
                    AccountErrorCode.PhoneInvalid,
                    String.format("%s is invalid", phone));
        }

        PhoneAccountEntity entity = phoneAccountMapper.selectByPhone(phone);
        if (entity == null) {
            throw ExceptionBuilder.build(AccountErrorCode.PhoneAccountNotExisted,
                    String.format("phone account[%s] not existed", phone));
        }

        String code = RandomUtil.nextString(6);
        new AccountLoginCodePhoneNotify().notify(
                new PhoneDest().setPhone(phone),
                new AccountLoginCodeNotifyParam().setCode(code)
        );

        phoneCodeLoginStrategy.saveLoginCode(phone, code);
        return code;
    }

    @Transactional
    @Override
    public <RT extends AbRegInfo> UserInfoEntity reg(
            IRegStrategy<RT> strategy, RT info) {
        return strategy.reg(info);
    }

    @Transactional
    @Override
    public <LT extends AbLoginInfo> UserInfoEntity login(
            ILoginStrategy<LT> strategy, LT info) {
        return strategy.login(info);
    }

    @Transactional
    @Override
    public void bind(UserInfoEntity entity, PhoneAccountEntity account) {

    }

    @Transactional
    @Override
    public void reBind(UserInfoEntity entity, PhoneAccountEntity accout) {

    }

    @Transactional
    @Override
    public void delete(UserInfoEntity entity) {

    }
}
