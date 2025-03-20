package com.demo.blogappwithsecuritydevtiro.service;

import com.demo.blogappwithsecuritydevtiro.domain.dto.AuthorDto;
import com.demo.blogappwithsecuritydevtiro.domain.dto.PostDto;
import com.demo.blogappwithsecuritydevtiro.domain.entity.User;
import com.demo.blogappwithsecuritydevtiro.domain.request.CreatePostRequest;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<PostDto> getAllPosts(UUID categoryId, UUID tagId);
    PostDto createPost(CreatePostRequest createPostRequest, User user);

}
