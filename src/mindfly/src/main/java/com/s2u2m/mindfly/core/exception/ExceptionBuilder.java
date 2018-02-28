package com.s2u2m.mindfly.core.exception;

import com.s2u2m.mindfly.core.exception.error.IErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ExceptionBuilder<ET extends IErrorCodeEnum> {

    private ET errCode;
    private String errMsg = "";

    public MindFlyException build() {
        int code = errCode.getTypeEnum().getType() << 20 | errCode.getCode();
        MindFlyException exception = new MindFlyException();
        exception.setErrCode(code);
        exception.setErrMsg(this.errMsg);
        return exception;
    }
}
