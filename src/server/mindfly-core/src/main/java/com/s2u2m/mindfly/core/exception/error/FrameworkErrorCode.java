package com.s2u2m.mindfly.core.exception.error;

public enum FrameworkErrorCode implements IErrorCodeEnum {
    Unknown(0),
    ComponentError(1),
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
    FrameworkErrorCode(int code) {
        this.code = code;
    }
}
