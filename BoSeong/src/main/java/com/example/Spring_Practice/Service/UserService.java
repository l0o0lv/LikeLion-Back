package com.example.Spring_Practice.Service;

import com.example.Spring_Practice.Dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto login(String uid, String password);
}