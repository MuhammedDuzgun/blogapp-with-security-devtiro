package com.demo.blogappwithsecuritydevtiro.repository;

import com.demo.blogappwithsecuritydevtiro.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {

    Optional<Tag> findByName(String name);

}
