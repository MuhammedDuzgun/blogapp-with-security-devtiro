package com.demo.blogappwithsecuritydevtiro.domain.dto;

import java.util.UUID;

public class CategoryDto {

    private UUID id;
    private String name;
    private long postCount;

    public CategoryDto() {
    }

    public CategoryDto(UUID id, String name, long postCount) {
        this.id = id;
        this.name = name;
        this.postCount = postCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPostCount() {
        return postCount;
    }

    public void setPostCount(long postCount) {
        this.postCount = postCount;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postCount=" + postCount +
                '}';
    }

}
