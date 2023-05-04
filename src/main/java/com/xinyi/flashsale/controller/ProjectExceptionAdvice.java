package com.xinyi.flashsale.controller;

import com.xinyi.flashsale.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// Exception Handler
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public String doException(Exception ex){
        System.out.println(ex.getMessage());
        return "Exception: " + ex.getMessage();
    }

    @ExceptionHandler(BusinessException.class)
    public String doBusinessException(Exception ex){
        System.out.println(ex.getMessage());
        return "BusinessException: "  + ex.getMessage();
    }
}
