package com.blog.business.dto;

import com.blog.base.bean.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TagDTO extends BaseDTO {

    private String name;
}
