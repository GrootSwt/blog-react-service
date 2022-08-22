package com.blog.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.business.dto.BlogTagDTO;
import com.blog.business.entity.BlogTag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogTagMapper extends BaseMapper<BlogTag> {

    List<BlogTagDTO> selectByBlogId(String blogId);
}
