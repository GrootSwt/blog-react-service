package com.blog.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.base.bean.Pageable;
import com.blog.base.bean.SearchData;
import com.blog.business.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    List<Blog> pageableSearch(SearchData searchData, Pageable pageable);

    Blog getBlogById(String id);
}
