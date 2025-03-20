package com.demo.blogappwithsecuritydevtiro.controller;

import com.demo.blogappwithsecuritydevtiro.domain.request.CreateTagRequest;
import com.demo.blogappwithsecuritydevtiro.domain.response.TagResponse;
import com.demo.blogappwithsecuritydevtiro.service.TagService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
        return ResponseEntity.ok(tagService.findAllTags());
    }

    @PostMapping
    public ResponseEntity<TagResponse> createTag(@Valid @RequestBody CreateTagRequest createTagRequest) {
        TagResponse createdTag = tagService.createTag(createTagRequest);
        return new ResponseEntity<>(createdTag, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable("id") UUID id) {
        tagService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
