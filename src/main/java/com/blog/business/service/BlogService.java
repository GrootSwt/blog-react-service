package com.blog.business.service;

import com.blog.base.bean.Pageable;
import com.blog.base.bean.SearchData;
import com.blog.business.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> pageableSearchBlog(SearchData searchData, Pageable pageable);

    Blog getBlogById(String id);

    Blog saveBlog(Blog blog);

    void deleteById(String id);
}
