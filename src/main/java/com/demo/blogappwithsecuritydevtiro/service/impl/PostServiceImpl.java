package com.demo.blogappwithsecuritydevtiro.service.impl;

import com.demo.blogappwithsecuritydevtiro.domain.PostStatus;
import com.demo.blogappwithsecuritydevtiro.domain.dto.AuthorDto;
import com.demo.blogappwithsecuritydevtiro.domain.dto.CategoryDto;
import com.demo.blogappwithsecuritydevtiro.domain.dto.PostDto;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Category;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Post;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Tag;
import com.demo.blogappwithsecuritydevtiro.domain.entity.User;
import com.demo.blogappwithsecuritydevtiro.domain.request.CreatePostRequest;
import com.demo.blogappwithsecuritydevtiro.domain.response.TagResponse;
import com.demo.blogappwithsecuritydevtiro.mapper.CategoryMapper;
import com.demo.blogappwithsecuritydevtiro.mapper.PostMapper;
import com.demo.blogappwithsecuritydevtiro.mapper.TagMapper;
import com.demo.blogappwithsecuritydevtiro.repository.CategoryRepository;
import com.demo.blogappwithsecuritydevtiro.repository.PostRepository;
import com.demo.blogappwithsecuritydevtiro.repository.TagRepository;
import com.demo.blogappwithsecuritydevtiro.service.CategoryService;
import com.demo.blogappwithsecuritydevtiro.service.PostService;

import com.demo.blogappwithsecuritydevtiro.service.TagService;
import com.demo.blogappwithsecuritydevtiro.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final TagRepository tagRepository;
    private final PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository, UserService userService, TagRepository tagRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
        this.tagRepository = tagRepository;
        this.postMapper = postMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostDto> getAllPosts(UUID categoryId, UUID tagId) {
        if (categoryId != null && tagId != null) {
            Category category = categoryRepository.findById(categoryId).get();
            Tag tag = tagRepository.findById(tagId).get();

            return postRepository.findAllByStatusAndCategoryAndTagsContaining(
                    PostStatus.PUBLISHED,
                    category,
                    tag
            ).stream().map(postMapper::mapToPostDto).collect(Collectors.toList());

        }
        return null;
    }

    @Transactional
    public PostDto createPost(CreatePostRequest createPostRequest, User user) {
        Post postToCreate = postMapper.mapToPost(createPostRequest);
        postToCreate.setUser(user);
        postToCreate.setStatus(PostStatus.PUBLISHED);
        return postMapper.mapToPostDto(postRepository.save(postToCreate));
    }

}
