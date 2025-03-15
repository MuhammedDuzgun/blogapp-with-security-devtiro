package com.demo.blogappwithsecuritydevtiro.controller;

import com.demo.blogappwithsecuritydevtiro.domain.dto.CategoryDto;
import com.demo.blogappwithsecuritydevtiro.domain.request.CreateCategoryRequest;
import com.demo.blogappwithsecuritydevtiro.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //get all categories
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    //save category
    @PostMapping
    public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        CategoryDto categoryDto = categoryService.saveCategory(createCategoryRequest);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }

    //delete category
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") UUID id) {
        categoryService.deleteCategoryWithCategoryId(id);
    }

}
