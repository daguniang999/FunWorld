package com.cw.fun.common;

import lombok.Data;

@Data
public class ResponseInfo<T> {

    public Integer code;

    private String message;

    private T data;

    public static ResponseInfo<Boolean> success() {
        return create(200, "成功", true);
    }

    public static <T> ResponseInfo<T> successData(T data) {
        return create(200, "成功", data);
    }

    public static ResponseInfo<Boolean> success(String message) {
        return create(200, message, false);
    }

    public static <T> ResponseInfo<T> create(Integer code, String message, T data) {
        ResponseInfo<T> info = new ResponseInfo<>();
        info.code = code;
        info.message = message;
        info.data = data;
        return info;
    }

    public static <T> ResponseInfo<T> failData(T data) {
        return create(0, "失败", data);
    }

    public static ResponseInfo<Boolean> fail() {
        return create(0, "失败", false);
    }

    public static ResponseInfo<Boolean> fail(String message) {
        return create(0, message, false);
    }
}
