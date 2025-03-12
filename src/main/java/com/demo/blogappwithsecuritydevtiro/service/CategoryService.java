package com.demo.blogappwithsecuritydevtiro.service;

import com.demo.blogappwithsecuritydevtiro.domain.dto.CategoryDto;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Category;
import com.demo.blogappwithsecuritydevtiro.domain.request.CreateCategoryRequest;
import com.demo.blogappwithsecuritydevtiro.mapper.CategoryMapper;
import com.demo.blogappwithsecuritydevtiro.repository.CategoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    //get all categories
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos;
        categoryDtos = categories.stream()
                .map(categoryMapper::mapToCategoryDto)
                .toList();
        return categoryDtos;
    }

    //save category
    @Transactional
    public CategoryDto saveCategory(CreateCategoryRequest createCategoryRequest) {
        if (categoryRepository.existsByName(createCategoryRequest.getName())) {
            throw new RuntimeException("Category with name : "+ createCategoryRequest.getName() + " already exists");
        }
        Category categoryToSave = categoryMapper.mapToCategory(createCategoryRequest);
        Category savedCategory = categoryRepository.save(categoryToSave);
        return categoryMapper.mapToCategoryDto(savedCategory);
    }

}
