package com.demo.blogappwithsecuritydevtiro.service;

import com.demo.blogappwithsecuritydevtiro.domain.entity.User;

import java.util.UUID;

public interface UserService {

    User findById(UUID id);

}
