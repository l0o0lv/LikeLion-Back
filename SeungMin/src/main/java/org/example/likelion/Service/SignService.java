package org.example.likelion.Service;

import org.apache.catalina.User;
import org.example.likelion.Dto.UserDto;
import org.example.likelion.LikelionApplication;

import java.util.List;

public interface SignService {
    UserDto getUserById(Long id);

    UserDto SignUp(UserDto userDto);

    List<UserDto> ReadAllUser();

    UserDto PatchUser(Long id, UserDto userDto);

    UserDto DeleteUser(Long id);
}
