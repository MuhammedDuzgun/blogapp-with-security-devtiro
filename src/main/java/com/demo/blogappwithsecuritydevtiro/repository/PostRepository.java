package com.demo.blogappwithsecuritydevtiro.repository;

import com.demo.blogappwithsecuritydevtiro.domain.PostStatus;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Category;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Post;
import com.demo.blogappwithsecuritydevtiro.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus status, Category category, Tag tag);
}
