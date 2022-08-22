package com.blog.base.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultData<T> {

    private Status status;

    private String message;

    private T data;

    private ResultData(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    private ResultData(Status status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultData<T> success(String message) {
        return new ResultData<T>(Status.success, message);
    }

    public static <T> ResultData<T> success(String message, T data) {
        return new ResultData<T>(Status.success, message, data);
    }

    public static <T> ResultData<T> failure(String message) {
        return new ResultData<T>(Status.failure, message);
    }

    public static <T> ResultData<T> failure(String message, T data) {
        return new ResultData<T>(Status.failure, message, data);
    }

}
