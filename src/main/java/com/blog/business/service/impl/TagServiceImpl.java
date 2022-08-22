package com.blog.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.business.entity.Tag;
import com.blog.business.mapper.TagMapper;
import com.blog.business.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> getAllTag() {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        return tagMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveTag(Tag tag) {
        tagMapper.insert(tag);
    }
}
