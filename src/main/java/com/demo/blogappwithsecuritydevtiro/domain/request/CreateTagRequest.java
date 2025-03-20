package com.demo.blogappwithsecuritydevtiro.domain.request;

import jakarta.validation.constraints.NotBlank;

public class CreateTagRequest {

    @NotBlank(message = "name cannot be blank")
    private String name;

    public CreateTagRequest() {
    }

    public CreateTagRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
