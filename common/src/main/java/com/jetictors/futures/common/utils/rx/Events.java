package com.jetictors.futures.common.utils.rx;

/**
 * 描述    :  EventBus传递数据封装类
 * author  : Jetictors
 * time    :  2018/1/29 17:16
 * version : v1.0.1
 */
public class Events <T>{

    public String code;
    public T content;

    public Events(String code, T content) {
        this.code = code;
        this.content = content;
    }

    public <T> T getContent() {
        return (T) content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
