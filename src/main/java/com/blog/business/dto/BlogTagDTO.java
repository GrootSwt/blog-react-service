package com.blog.business.dto;

import com.blog.base.bean.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BlogTagDTO extends BaseDTO {

    private String blogId;

    private String tagId;

    private String tagName;
}
