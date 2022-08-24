package com.blog.base.bean;

import lombok.Data;

@Data
public class Pageable {

    private Integer page = 1;

    private Integer size = 20;

    private Long offset = 0L;

    private Long total = 0L;
}
