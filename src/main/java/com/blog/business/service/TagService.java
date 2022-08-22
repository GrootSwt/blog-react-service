package com.blog.business.service;

import com.blog.business.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTag();

    void saveTag(Tag tag);
}
