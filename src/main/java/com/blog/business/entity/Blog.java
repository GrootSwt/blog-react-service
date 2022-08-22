package com.blog.business.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.blog.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Blog extends BaseEntity {

    private String title;

    private String description;

    private String content;
    @TableField(exist = false)
    private List<BlogTag> blogTags;
}
