package com.springboot.goodsManage.model.result;

public class Result {
    /** 错误码. */
    private Integer status;

    /** 提示信息. */
    private String message;

    /** 具体的内容. */
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
