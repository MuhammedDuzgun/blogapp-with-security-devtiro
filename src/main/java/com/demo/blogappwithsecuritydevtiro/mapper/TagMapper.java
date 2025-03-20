package com.demo.blogappwithsecuritydevtiro.mapper;

import com.demo.blogappwithsecuritydevtiro.domain.entity.Tag;
import com.demo.blogappwithsecuritydevtiro.domain.request.CreateTagRequest;
import com.demo.blogappwithsecuritydevtiro.domain.response.TagResponse;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {

    public TagResponse mapToTagResponse(Tag tag) {
        TagResponse tagResponse = new TagResponse();
        tagResponse.setId(tag.getId());
        tagResponse.setName(tag.getName());
        return tagResponse;
    }

    public Tag mapToTag(CreateTagRequest createTagRequest) {
        Tag tag = new Tag();
        tag.setName(createTagRequest.getName());
        return tag;
    }

}
