package com.s2u2m.mindfly.core.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * The type Mind fly exception.
 * @author Amos Xia
 */
@Getter
@Setter
public abstract class BaseMindFlyException extends RuntimeException {
    private int errCode;
    private String errMsg;
}
