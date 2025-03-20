package com.demo.blogappwithsecuritydevtiro.domain.dto;

import com.demo.blogappwithsecuritydevtiro.domain.PostStatus;
import com.demo.blogappwithsecuritydevtiro.domain.response.TagResponse;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class PostDto {

    private UUID id;
    private String title;
    private String content;
    private AuthorDto authorDto;
    private CategoryDto categoryDto;
    private Set<TagResponse> tags;
    private Integer readingTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PostStatus postStatus;

    public PostDto() {
    }

    public PostDto(UUID id, String title, String content, AuthorDto authorDto, CategoryDto categoryDto, Set<TagResponse> tags, Integer readingTime, LocalDateTime createdAt, LocalDateTime updatedAt, PostStatus postStatus) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorDto = authorDto;
        this.categoryDto = categoryDto;
        this.tags = tags;
        this.readingTime = readingTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.postStatus = postStatus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public Set<TagResponse> getTags() {
        return tags;
    }

    public void setTags(Set<TagResponse> tags) {
        this.tags = tags;
    }

    public Integer getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(Integer readingTime) {
        this.readingTime = readingTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", categoryDto=" + categoryDto +
                ", tags=" + tags +
                ", readingTime=" + readingTime +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", postStatus=" + postStatus +
                '}';
    }

}
