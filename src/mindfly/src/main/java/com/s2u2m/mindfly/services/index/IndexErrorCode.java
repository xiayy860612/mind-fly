package com.s2u2m.mindfly.services.index;

import com.s2u2m.mindfly.core.exception.error.ErrorTypeEnum;
import com.s2u2m.mindfly.core.exception.error.IErrorCodeEnum;

/**
 * The enum Index error code.
 *
 * @author Amos Xia
 */
public enum IndexErrorCode implements IErrorCodeEnum {
    Unknown(1)
    ;

    @Override
    public ErrorTypeEnum getTypeEnum() {
        return ErrorTypeEnum.Unknown;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    private int code;
    IndexErrorCode(int code) {
        this.code = code;
    }
}
