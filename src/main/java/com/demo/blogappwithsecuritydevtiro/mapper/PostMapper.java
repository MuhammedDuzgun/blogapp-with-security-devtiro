package com.demo.blogappwithsecuritydevtiro.mapper;

import com.demo.blogappwithsecuritydevtiro.domain.dto.PostDto;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Category;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Post;
import com.demo.blogappwithsecuritydevtiro.domain.request.CreatePostRequest;
import com.demo.blogappwithsecuritydevtiro.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    private final CategoryRepository categoryRepository;

    public PostMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Post mapToPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        Category category = categoryRepository.findById(createPostRequest.getCategoryId()).get();
        post.setTitle(createPostRequest.getTitle());
        post.setContent(createPostRequest.getContent());
        post.setCategory(category);
        return post;
    }

    public PostDto mapToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setPostStatus(post.getStatus());
        postDto.setReadingTime(post.getReadingTime());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setUpdatedAt(post.getUpdatedAt());
        return postDto;
    }

}
