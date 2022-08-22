package com.blog.business.dto;

import com.blog.base.bean.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class BlogDTO extends BaseDTO {

    private String title;

    private String description;

    private String content;

    private List<BlogTagDTO> blogTags;

}
