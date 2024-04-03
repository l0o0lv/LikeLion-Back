package com.example.likelion.Service;

import com.example.likelion.Dto.UserDto;

import java.util.List;

public interface SignService {
    UserDto getUserById(Long id);

    UserDto SignUp(UserDto userDto);

    List<UserDto> ReadAllUser();

    UserDto PatchUser(Long id, UserDto userDto);

    UserDto DeleteUser(Long id);
}
