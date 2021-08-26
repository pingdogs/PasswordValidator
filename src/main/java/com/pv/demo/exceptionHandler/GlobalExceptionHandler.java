package com.pv.demo.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerWebInputException;

import com.pv.demo.constant.ServiceExceptionEnum;
import com.pv.demo.core.vo.CommonResult;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(PasswordUnableException.class)
    public CommonResult PasswordUnableExceptionHandler(PasswordUnableException ex) {
        return CommonResult.error(ex.getCode(),
                ex.getMessage());
    }
    
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(Exception e) {
        return CommonResult.error(ServiceExceptionEnum.SYS_ERROR.getCode(),
                ServiceExceptionEnum.SYS_ERROR.getMessage());
    }

}
