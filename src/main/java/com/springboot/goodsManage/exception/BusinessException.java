package com.springboot.goodsManage.exception;

public class BusinessException extends Exception {

    // 普通业务错误代码为300
    private Integer code = 300;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code,String message) {
        super(message);
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
