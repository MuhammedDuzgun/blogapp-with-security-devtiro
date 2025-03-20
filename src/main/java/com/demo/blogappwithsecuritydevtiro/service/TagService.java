package com.demo.blogappwithsecuritydevtiro.service;

import com.demo.blogappwithsecuritydevtiro.domain.request.CreateTagRequest;
import com.demo.blogappwithsecuritydevtiro.domain.response.TagResponse;

import java.util.List;
import java.util.UUID;

public interface TagService {
    List<TagResponse> findAllTags();
    TagResponse createTag(CreateTagRequest createTagRequest);
    void deleteTag(UUID id);
    TagResponse findTagById(UUID id);
}
