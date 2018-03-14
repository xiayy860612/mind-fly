package com.s2u2m.mindfly.core.exception.error;

public enum ServerErrorCode implements IErrorCodeEnum {

    /**
     *
     */
    // uid error: 1XX
    UidGenerateUidError(101)
    ;

    @Override
    public ErrorTypeEnum getTypeEnum() {
        return ErrorTypeEnum.ServerError;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    private int code;
    ServerErrorCode(int code) {
        this.code = code;
    }
}
