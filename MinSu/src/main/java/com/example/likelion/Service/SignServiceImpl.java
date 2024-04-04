package com.example.likelion.Service;

import com.example.likelion.Dto.UserDto;
import com.example.likelion.Entity.UserEntity;
import com.example.likelion.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignServiceImpl implements SignService {

    private final UserRepository userRepository;

    @Autowired
    public SignServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDto SignUp(UserDto userDto){
        //DTO를 Entity로 변환
        UserEntity userEntity = UserDto.DtoToEntity(userDto);

        // DB에 저장
        userRepository.save(userEntity);

        return UserEntity.EntityToDto(userEntity);
    }

    @Override
    public UserDto getUserById(Long id){
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserEntity.EntityToDto(userEntity);
    }

    @Override
    public List<UserDto> ReadAllUser(){
        return null;
    }

    @Override
    public UserDto UpdateUser(UserDto userDto){
        UserEntity userEntity = UserDto.DtoToEntity(userDto);

        userRepository.save(userEntity);

        return userEntity.EntityToDto(userEntity);
    }

    @Override   // 구글링 필요
    public void DeleteUser(Long id){
        UserEntity user = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        userRepository.delete(user);
    }
}
