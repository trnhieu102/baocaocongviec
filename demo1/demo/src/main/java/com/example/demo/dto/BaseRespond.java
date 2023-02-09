package com.example.demo.dto;

import org.springframework.http.ResponseEntity;

public class BaseRespond {
    protected String message;
    protected Integer code;

    protected Object data;

    public BaseRespond() {
    }

    public BaseRespond(String message, Integer code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseRespond{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
