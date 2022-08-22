package com.blog.business.convertor;

import com.blog.base.convertor.BaseConvertor;
import com.blog.business.dto.BlogDTO;
import com.blog.business.dto.BlogTagDTO;
import com.blog.business.entity.Blog;
import com.blog.business.entity.BlogTag;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlogConvertor extends BaseConvertor<Blog, BlogDTO> {
    @Override
    public BlogDTO toDTO(Blog entity) {
        BlogDTO dto = new BlogDTO();
        BeanUtils.copyProperties(entity, dto);
        List<BlogTag> blogTags = entity.getBlogTags();
        List<BlogTagDTO> blogTagDTOs = new ArrayList<>();
        for (BlogTag blogTag : blogTags) {
            BlogTagDTO blogTagDTO = new BlogTagDTO();
            BeanUtils.copyProperties(blogTag, blogTagDTO);
            blogTagDTOs.add(blogTagDTO);
        }
        dto.setBlogTags(blogTagDTOs);
        return dto;
    }

    @Override
    public Blog toEntity(BlogDTO dto) {
        Blog entity = new Blog();
        BeanUtils.copyProperties(dto, entity);
        List<BlogTagDTO> blogTagDTOs = dto.getBlogTags();
        List<BlogTag> blogTags = new ArrayList<>();
        for (BlogTagDTO blogTagDTO : blogTagDTOs) {
            BlogTag blogTag = new BlogTag();
            BeanUtils.copyProperties(blogTagDTO, blogTag);
            blogTags.add(blogTag);
        }
        entity.setBlogTags(blogTags);
        return entity;
    }
}
