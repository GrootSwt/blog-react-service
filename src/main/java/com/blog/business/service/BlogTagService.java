package com.blog.business.service;

import com.blog.business.entity.BlogTag;

import java.util.List;

public interface BlogTagService {

    void deleteByBlogId(String blogId);

    void saveBlogTags(List<BlogTag> blogTags);
}
