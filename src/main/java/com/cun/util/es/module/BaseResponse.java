package com.cun.util.es.module;


import com.cun.util.es.constant.RetCode;

public class BaseResponse<T> {
    public int code;
    public String message;
    public T data;

    public BaseResponse success(T data) {
        this.code = RetCode.SUCCESS.code();
        this.message = "";
        this.data = data;
        return this;
    }

    public BaseResponse success(String message, T data) {
        this.code = RetCode.SUCCESS.code();
        this.message = message;
        this.data = data;
        return this;
    }

    public BaseResponse success(String message) {
        this.code = RetCode.SUCCESS.code();
        this.message = message;
        return this;
    }

    public BaseResponse success() {
        this.code = RetCode.SUCCESS.code();
        this.message = "";
        this.data = null;
        return this;
    }

    public BaseResponse error(int code, String error) {
        this.code = code;
        this.message = error;
        return this;
    }

    public BaseResponse error(String error) {
        this.code = RetCode.FAILURE.code();
        this.message = error;
        return this;
    }

    public BaseResponse error(int code, String error, T data) {
        this.code = code;
        this.message = error;
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
