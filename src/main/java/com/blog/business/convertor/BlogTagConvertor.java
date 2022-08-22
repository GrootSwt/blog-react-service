package com.blog.business.convertor;

import com.blog.base.convertor.BaseConvertor;
import com.blog.business.dto.BlogTagDTO;
import com.blog.business.entity.BlogTag;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BlogTagConvertor extends BaseConvertor<BlogTag, BlogTagDTO> {
    @Override
    public BlogTagDTO toDTO(BlogTag entity) {
        BlogTagDTO dto = new BlogTagDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public BlogTag toEntity(BlogTagDTO dto) {
        BlogTag entity = new BlogTag();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
