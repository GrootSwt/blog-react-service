package com.blog.business.entity;

import com.blog.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity {

    private String name;

}
