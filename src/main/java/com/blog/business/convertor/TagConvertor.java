package com.blog.business.convertor;

import com.blog.base.convertor.BaseConvertor;
import com.blog.business.dto.TagDTO;
import com.blog.business.entity.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TagConvertor extends BaseConvertor<Tag, TagDTO> {
    @Override
    public TagDTO toDTO(Tag entity) {
        TagDTO dto = new TagDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public Tag toEntity(TagDTO dto) {
        Tag entity = new Tag();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
