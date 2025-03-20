package com.demo.blogappwithsecuritydevtiro.controller;

import com.demo.blogappwithsecuritydevtiro.domain.dto.AuthorDto;
import com.demo.blogappwithsecuritydevtiro.domain.dto.PostDto;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Post;
import com.demo.blogappwithsecuritydevtiro.domain.entity.User;
import com.demo.blogappwithsecuritydevtiro.domain.request.CreatePostRequest;
import com.demo.blogappwithsecuritydevtiro.mapper.UserMapper;
import com.demo.blogappwithsecuritydevtiro.security.CustomUserDetails;
import com.demo.blogappwithsecuritydevtiro.service.PostService;
import com.demo.blogappwithsecuritydevtiro.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final UserMapper userMapper;

    public PostController(PostService postService, UserService userService, UserMapper userMapper) {
        this.postService = postService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(@RequestParam(required = false) UUID categoryId,
                                                      @RequestParam(required = false) UUID tagId) {
        List<PostDto> posts = postService.getAllPosts(categoryId, tagId);
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody CreatePostRequest createPostRequest,
                                              @AuthenticationPrincipal CustomUserDetails userDetails) {

        User user = userService.findById(userDetails.getUserId());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        PostDto createdPost = postService.createPost(createPostRequest, user);

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

}
