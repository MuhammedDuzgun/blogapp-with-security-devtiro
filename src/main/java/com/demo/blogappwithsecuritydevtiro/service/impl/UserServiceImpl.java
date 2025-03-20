package com.demo.blogappwithsecuritydevtiro.service.impl;

import com.demo.blogappwithsecuritydevtiro.domain.entity.User;
import com.demo.blogappwithsecuritydevtiro.repository.UserRepository;
import com.demo.blogappwithsecuritydevtiro.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
    }
}
