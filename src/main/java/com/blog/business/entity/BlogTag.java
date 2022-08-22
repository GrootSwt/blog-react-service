package com.blog.business.entity;

import com.blog.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BlogTag extends BaseEntity {

    private String blogId;

    private String tagId;

    private String tagName;
}
