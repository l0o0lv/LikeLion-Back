package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;

public interface UserService {
    UserEntity signup(UserDto userDto);

    UserEntity read(Long id);

    UserEntity update(Long id, UserDto userDto);

    boolean delete(Long id);
}
