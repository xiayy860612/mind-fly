package com.s2u2m.mindfly.core.exception.error;

import lombok.Getter;

@Getter
public enum ErrorTypeEnum {

    NoError(0),
    Unknown(1)
    ;

    private int type = 0;
    ErrorTypeEnum(int type) {
        this.type = type;
    }
}
