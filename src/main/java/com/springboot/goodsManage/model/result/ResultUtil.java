package com.springboot.goodsManage.model.result;

public class ResultUtil {

    public static Result success(String message) {
        Result result = new Result();
        result.setStatus(200);
        result.setMessage(message.isEmpty() ? "成功": message);
        return result;
    }

    public static Result success(String message, Object object) {
        Result result = new Result();
        result.setStatus(200);
        result.setMessage(message.isEmpty() ? "成功": message);
        result.setData(object);
        return result;
    }

    public static Result error(Integer status, String message) {
        Result result = new Result();
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }
}
