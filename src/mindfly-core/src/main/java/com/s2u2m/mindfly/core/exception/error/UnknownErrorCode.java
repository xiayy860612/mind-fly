package com.s2u2m.mindfly.core.exception.error;

public enum UnknownErrorCode implements IErrorCodeEnum {
    Unknown(0)
    ;

    @Override
    public ErrorTypeEnum getTypeEnum() {
        return null;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    private int code = 0;
    UnknownErrorCode(int code) {
        this.code = code;
    }
}
