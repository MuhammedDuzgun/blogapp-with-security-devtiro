package com.demo.blogappwithsecuritydevtiro.repository;

import com.demo.blogappwithsecuritydevtiro.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    boolean existsByName(String name);
}
