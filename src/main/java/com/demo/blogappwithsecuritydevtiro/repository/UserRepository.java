package com.demo.blogappwithsecuritydevtiro.repository;

import com.demo.blogappwithsecuritydevtiro.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
