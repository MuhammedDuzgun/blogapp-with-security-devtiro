package com.demo.blogappwithsecuritydevtiro.domain.request;

import com.demo.blogappwithsecuritydevtiro.domain.PostStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

public class CreatePostRequest {

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "content is required")
    private String content;

    @NotNull(message = "category id is required")
    private UUID categoryId;

    private Set<UUID> tagIds;

    public CreatePostRequest() {
    }

    public CreatePostRequest(String title, String content, UUID categoryId, Set<UUID> tagId) {
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.tagIds = tagIds;
    }

    public @NotBlank(message = "title is required") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "title is required") String title) {
        this.title = title;
    }

    public @NotBlank(message = "content is required") String getContent() {
        return content;
    }

    public void setContent(@NotBlank(message = "content is required") String content) {
        this.content = content;
    }

    public @NotNull(message = "category id is required") UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull(message = "category id is required") UUID categoryId) {
        this.categoryId = categoryId;
    }

    public Set<UUID> getTagIds() {
        return tagIds;
    }

    public void setTagIds(Set<UUID> tagIds) {
        this.tagIds = tagIds;
    }

    @Override
    public String toString() {
        return "CreatePostRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", categoryId=" + categoryId +
                ", tagIds=" + tagIds +
                '}';
    }

}
