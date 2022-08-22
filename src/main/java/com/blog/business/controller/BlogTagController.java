package com.blog.business.controller;

import com.blog.business.convertor.BlogTagConvertor;
import com.blog.business.service.BlogTagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "blogTag")
public class BlogTagController {
    @Resource
    private BlogTagConvertor blogTagConvertor;
    @Resource
    private BlogTagService blogTagService;
}
