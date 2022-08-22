package com.blog.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.business.entity.BlogTag;
import com.blog.business.mapper.BlogTagMapper;
import com.blog.business.service.BlogTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogTagServiceImpl implements BlogTagService {

    @Resource
    private BlogTagMapper blogTagMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByBlogId(String blogId) {
        QueryWrapper<BlogTag> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_id", blogId);
        blogTagMapper.delete(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBlogTags(List<BlogTag> blogTags) {
        for (BlogTag blogTag : blogTags) {
            blogTagMapper.insert(blogTag);
        }
    }
}
