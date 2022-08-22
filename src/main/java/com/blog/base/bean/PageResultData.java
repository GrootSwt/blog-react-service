package com.blog.base.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResultData<T> {
    private Status status;

    private String message;

    private T data;

    private Pageable pageable;

    private PageResultData(Status status, String message, T data, Pageable pageable) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.pageable = pageable;
    }

    public static <T> PageResultData<T> success(String message, T data, Pageable pageable) {
        return new PageResultData<>(Status.success, message, data, pageable);
    }
}
