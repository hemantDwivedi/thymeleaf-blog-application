package com.project.blog.service;

import com.project.blog.dto.UserDto;
import com.project.blog.model.User;

import java.util.List;

public interface UserService {
    void createUser(UserDto userDto);
    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
