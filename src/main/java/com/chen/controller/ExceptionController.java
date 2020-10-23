package com.chen.controller;

import com.chen.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.controller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/22 16:07
 * @Version: 1.0
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    @ResponseBody
    public Result exception(Exception e){
        return new Result(false,e.getMessage(),null);
    }
}
