package com.example.likelion.Service;

import com.example.likelion.Dto.UserDto;

import java.util.List;

public interface SignService {
    UserDto getUserById(Long id);

    UserDto SignUp(UserDto userDto);

    List<UserDto> ReadAllUser();

    UserDto UpdateUser(UserDto userDto);

    void DeleteUser(Long id);
}
