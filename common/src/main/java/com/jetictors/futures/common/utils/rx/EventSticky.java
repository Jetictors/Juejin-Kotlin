package com.jetictors.futures.common.utils.rx;

/**
 * 描述    :  RxBus 使用粘性的消息
 * author  : Jetictors
 * time    :  2018/1/29 17:16
 * version : v1.0.1
 */
public class EventSticky<T> {

    public String code;
    public T content;

    public EventSticky(String code, T content) {
        this.code = code;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public <T> T getContent() {
        return (T) content;
    }

    public void setContent(T content) {
        this.content = content;
    }

}
