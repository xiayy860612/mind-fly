package com.s2u2m.mindfly.core.exception.error;

import lombok.Getter;

@Getter
public enum ErrorTypeEnum {

    NoError(0),
    Unknown(1),
    // error raised in runtime
    ServerError(2),

    /**
     * Internal Error <= 100, customized error > 100
     */
    AccountServiceError(101)
    ;

    public static final int errorTypeLength = 20;

    private int type = 0;
    ErrorTypeEnum(int type) {
        this.type = type;
    }
}
