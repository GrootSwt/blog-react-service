package com.blog.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.base.bean.Pageable;
import com.blog.base.bean.SearchData;
import com.blog.business.entity.Blog;
import com.blog.business.entity.BlogTag;
import com.blog.business.entity.Tag;
import com.blog.business.mapper.BlogMapper;
import com.blog.business.service.BlogService;
import com.blog.business.service.BlogTagService;
import com.blog.business.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;
    @Resource
    private TagService tagService;
    @Resource
    private BlogTagService blogTagService;

    @Override
    public List<Blog> pageableSearchBlog(SearchData searchData, Pageable pageable) {
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        Long total = blogMapper.selectCount(wrapper);
        pageable.setTotal(total);
        return blogMapper.pageableSearch(searchData, pageable);
    }

    @Override
    public Blog getBlogById(String id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Blog saveBlog(Blog blog) {
        List<BlogTag> blogTags = blog.getBlogTags();
        if (!StringUtils.hasText(blog.getId())) {
            blogMapper.insert(blog);
        } else {
            blogMapper.updateById(blog);

        }
        for (BlogTag blogTag : blogTags) {
            if (!StringUtils.hasText(blogTag.getTagId())) {
                Tag tag = new Tag();
                tag.setName(blogTag.getTagName());
                tagService.saveTag(tag);
                blogTag.setTagId(tag.getId());
            }
            blogTag.setBlogId(blog.getId());
            blogTag.setId(null);
        }
        blogTagService.deleteByBlogId(blog.getId());
        blogTagService.saveBlogTags(blogTags);
        return getBlogById(blog.getId());
    }
}
