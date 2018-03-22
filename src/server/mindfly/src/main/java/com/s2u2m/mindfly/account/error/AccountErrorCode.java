package com.s2u2m.mindfly.account.error;

import com.s2u2m.mindfly.core.exception.error.ErrorTypeEnum;
import com.s2u2m.mindfly.core.exception.error.IErrorCodeEnum;

/**
 * The enum Index error code.
 *
 * @author Amos Xia
 */
public enum AccountErrorCode implements IErrorCodeEnum {
    Unknown(1),

    LoginPasswordIncorrect(31),

    // UserName Account related Error
    UserNameOrPasswordInvalid(101),
    UserNameAccountAlreadyExisted(102),
    UserNameAccountRegPwdNotMatched(103),
    UserNameNotExisted(104),

    // Phone Account
    PhoneInvalid(201),
    PhoneAccountAlreadyExisted(202),
    PhoneRegCodeNotExisted(203),
    PhoneRegCodeNotMatched(204),
    PhoneAccountNotExisted(205),
    ;

    @Override
    public ErrorTypeEnum getTypeEnum() {
        return ErrorTypeEnum.AccountServiceError;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    private int code;
    AccountErrorCode(int code) {
        this.code = code;
    }
}
