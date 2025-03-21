package com.demo.blogappwithsecuritydevtiro.domain.dto;

import java.util.UUID;

public class AuthorDto {

    private UUID id;
    private String name;

    public AuthorDto() {
    }

    public AuthorDto(UUID id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
