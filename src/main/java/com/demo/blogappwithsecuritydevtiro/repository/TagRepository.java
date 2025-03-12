package com.demo.blogappwithsecuritydevtiro.repository;

import com.demo.blogappwithsecuritydevtiro.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
