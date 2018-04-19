package com.example.demo.controller;

import com.example.demo.domain.ErrorInfo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ziqin.lei
 * @since 2018/4/19
 */
@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Throwable.class)
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Throwable throwable) {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(throwable.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("Some Data");
        errorInfo.setUrl(req.getRequestURL().toString());
        return errorInfo;
    }
}
