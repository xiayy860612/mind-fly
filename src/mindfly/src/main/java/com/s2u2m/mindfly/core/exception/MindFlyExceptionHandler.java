package com.s2u2m.mindfly.core.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.s2u2m.mindfly.core.serialization.ErrorResponse;

@RestControllerAdvice
public class MindFlyExceptionHandler {

    @ExceptionHandler(MindFlyException.class)
    @ResponseStatus(HttpStatus.OK)
    public ErrorResponse mindflyExceptionHandler(
        MindFlyException exception, HttpServletRequest httpServletRequest) {
        ErrorResponse response = new ErrorResponse();
        response.setCode(exception.getErrCode());
        response.setErrMsg(exception.getErrMsg());
        return response;
    }
}
