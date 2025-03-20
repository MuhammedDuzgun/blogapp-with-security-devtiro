package com.demo.blogappwithsecuritydevtiro.service.impl;

import com.demo.blogappwithsecuritydevtiro.domain.entity.Tag;
import com.demo.blogappwithsecuritydevtiro.domain.request.CreateTagRequest;
import com.demo.blogappwithsecuritydevtiro.domain.response.TagResponse;
import com.demo.blogappwithsecuritydevtiro.exception.TagAlreadyExistsException;
import com.demo.blogappwithsecuritydevtiro.exception.TagNotFoundException;
import com.demo.blogappwithsecuritydevtiro.mapper.TagMapper;
import com.demo.blogappwithsecuritydevtiro.repository.TagRepository;
import com.demo.blogappwithsecuritydevtiro.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagServiceImpl(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Override
    public List<TagResponse> findAllTags() {
        return tagRepository.findAll()
                .stream().map(tagMapper::mapToTagResponse).toList();
    }

    @Transactional
    @Override
    public TagResponse createTag(CreateTagRequest createTagRequest) {
        Tag isTagExists = tagRepository.findByName(createTagRequest.getName()).
                orElse(null);
        if (isTagExists == null) {
            Tag tagToCreate = tagMapper.mapToTag(createTagRequest);
            Tag savedTag = tagRepository.save(tagToCreate);
            return tagMapper.mapToTagResponse(savedTag);
        }
        throw new TagAlreadyExistsException("Tag already exists");
    }

    @Transactional
    @Override
    public void deleteTag(UUID id) {
        Tag tagToDelete = tagRepository.findById(id)
                        .orElseThrow(()-> new TagNotFoundException("Tag with id " + id + " not found"));
        tagRepository.delete(tagToDelete);
    }

    @Override
    public TagResponse findTagById(UUID id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(()-> new TagNotFoundException("Tag with id " + id + " not found"));
        return tagMapper.mapToTagResponse(tag);
    }

}
