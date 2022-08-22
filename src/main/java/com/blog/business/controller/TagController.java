package com.blog.business.controller;

import com.blog.base.bean.ResultData;
import com.blog.business.convertor.TagConvertor;
import com.blog.business.dto.TagDTO;
import com.blog.business.entity.Tag;
import com.blog.business.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "tag")
public class TagController {

    @Resource
    private TagConvertor tagConvertor;

    @Resource
    private TagService tagService;

    @GetMapping(value = "getAllTag")
    public ResultData<List<TagDTO>> getAllTag() {
        List<Tag> tags = tagService.getAllTag();
        List<TagDTO> tagDTOs = tagConvertor.toListDTO(tags);
        return ResultData.success("获取全部标签成功！", tagDTOs);
    }
}
