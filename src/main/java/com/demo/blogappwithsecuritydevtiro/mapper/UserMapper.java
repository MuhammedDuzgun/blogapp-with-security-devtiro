package com.demo.blogappwithsecuritydevtiro.mapper;

import com.demo.blogappwithsecuritydevtiro.domain.dto.AuthorDto;
import com.demo.blogappwithsecuritydevtiro.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public AuthorDto mapToAuthorDto(User user) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(user.getId());
        authorDto.setName(user.getName());
        return authorDto;
    }

}
