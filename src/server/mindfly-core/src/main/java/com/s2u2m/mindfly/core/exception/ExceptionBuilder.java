package com.s2u2m.mindfly.core.exception;

import com.s2u2m.mindfly.core.exception.error.ErrorTypeEnum;
import com.s2u2m.mindfly.core.exception.error.IErrorCodeEnum;

public class ExceptionBuilder {

    public static <ET extends IErrorCodeEnum> MindFlyException build(
            ET errCode, String errMsg) {
        int code = errCode.getTypeEnum().getType() << ErrorTypeEnum.errorTypeLength
                | errCode.getCode();
        MindFlyException exception = new MindFlyException();
        exception.setErrCode(code);
        exception.setErrMsg(errMsg);
        return exception;
    }
}
