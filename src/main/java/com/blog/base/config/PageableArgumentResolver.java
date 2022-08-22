package com.blog.base.config;

import com.blog.base.bean.Pageable;
import com.blog.base.exception.BusinessRuntimeException;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PageableArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Pageable.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Pageable pageable = new Pageable();
        String rule = "^[-+]?[0-9]+$";
        webRequest.getParameterNames().forEachRemaining((name) -> {
            if ("p_page".equals(name)) {
                String[] values = webRequest.getParameterValues(name);
                if (values != null && values.length == 1 && values[0].matches(rule)) {
                    pageable.setPage(Integer.valueOf(values[0]));
                } else {
                    throw new BusinessRuntimeException("p_page为空或非数值类型！");
                }
            }
            if ("p_size".equals(name)) {
                String[] values = webRequest.getParameterValues(name);
                if (values != null && values.length == 1 && values[0].matches(rule)) {
                    pageable.setSize(Integer.valueOf(values[0]));
                } else {
                    throw new BusinessRuntimeException("p_size为空或非数值类型！");
                }
            }
        });
        if (pageable.getPage() == null || pageable.getSize() == null) {
            throw new BusinessRuntimeException(("缺少p_page或p_size"));
        }
        pageable.setOffset((long) (pageable.getPage() - 1) * pageable.getSize());
        return pageable;
    }
}
