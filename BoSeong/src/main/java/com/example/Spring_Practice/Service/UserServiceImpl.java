package com.example.Spring_Practice.Service;

import com.example.Spring_Practice.Dto.UserDto;
import com.example.Spring_Practice.Entity.UserEntity;
import com.example.Spring_Practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        if (userRepository.existsByUidOrNickname(userDto.getUid(), userDto.getNickname())) {
            throw new RuntimeException("User ID or Nickname already exists.");
        }
        UserEntity userEntity = UserDto.DtoToEntity(userDto);

       userRepository.save(userEntity);
        return UserEntity.EntityToDto(userEntity);
    }

    @Override
    public UserDto login(String uid, String password) {
        UserEntity user = userRepository.findByUidAndPassword(uid, password)
                .orElseThrow(() -> new RuntimeException("Invalid login credentials."));
        return UserEntity.EntityToDto(user);
    }
}
