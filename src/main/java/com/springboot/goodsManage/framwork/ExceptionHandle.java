package com.springboot.goodsManage.framwork;

import com.springboot.goodsManage.exception.BusinessException;
import com.springboot.goodsManage.model.result.Result;
import com.springboot.goodsManage.model.result.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result Handle(Exception e) {

        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return ResultUtil.error(businessException.getCode(), businessException.getMessage());
        } else {
            Logger log = Logger.getLogger("ERROR");
            log.info(e.getCause().toString());

            //将系统异常以打印出来
            return ResultUtil.error(500, "服务异常！");
        }

    }
}
