package com.yundian.imc.controller.platform;

import com.yundian.imc.common.ResponseCode;
import com.yundian.imc.common.base.BaseResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdviceController {

    @ExceptionHandler(BindException.class)
    public String constraintExceptionHandle(BindException e){
        return new BaseResponse(ResponseCode.ERROR, e.getBindingResult().getFieldError().getDefaultMessage()).toJson();
    }

}
