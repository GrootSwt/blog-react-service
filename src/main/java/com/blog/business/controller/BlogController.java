package com.blog.business.controller;

import com.blog.base.bean.*;
import com.blog.business.convertor.BlogConvertor;
import com.blog.business.dto.BlogDTO;
import com.blog.business.entity.Blog;
import com.blog.business.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "blog")
public class BlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private BlogConvertor blogConvertor;

    @GetMapping(value = "pageableSearchBlog")
    public PageResultData<List<BlogDTO>> pageableSearchBlog(SearchData searchData, Pageable pageable) {
        List<Blog> blogList = blogService.pageableSearchBlog(searchData, pageable);
        return PageResultData.success("获取分页列表成功！", blogConvertor.toListDTO(blogList), pageable);
    }

    @GetMapping(value = "{id}/getBlogById")
    public ResultData<BlogDTO> getBlogById(@PathVariable String id) {
        Blog blog = blogService.getBlogById(id);
        BlogDTO blogDTO = blogConvertor.toDTO(blog);
        return ResultData.success("获取博客详情成功", blogDTO);
    }

    @PostMapping(value = "saveBlog")
    public ResultData<BlogDTO> saveBlog(@RequestBody BlogDTO blogDTO) {
        Blog blog = blogConvertor.toEntity(blogDTO);
        blog = blogService.saveBlog(blog);
        blogDTO = blogConvertor.toDTO(blog);
        return ResultData.success("保存博客成功！", blogDTO);
    }

    @DeleteMapping(value = "{id}/deleteBlogById")
    public PageResultData<List<BlogDTO>> deleteBlogById(@PathVariable String id) {
        blogService.deleteById(id);
        return this.pageableSearchBlog(new SearchData(),new Pageable());
    }
}
