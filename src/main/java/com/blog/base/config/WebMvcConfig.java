package com.blog.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * handler method searchData、pageable 形参解析器
     * @param argumentResolvers handler method 形参解析器列表
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // searchData形参解析器
        argumentResolvers.add(new SearchDataArgumentResolver());
        // pageable形参解析器
        argumentResolvers.add(new PageableArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }
}
