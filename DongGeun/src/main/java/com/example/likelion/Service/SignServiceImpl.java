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
    public SignServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDto SignUp(UserDto userDto) {
        // DTO를 Entity로 변환
        UserEntity userEntity = UserDto.DtoToEntity(userDto);

        // DB에 저장
        userRepository.save(userEntity);

        return UserEntity.EntityToDto(userEntity);
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserEntity.EntityToDto(userEntity);
    }

    @Override
    public List<UserDto> ReadAllUser() {
        return null;
    }

    @Override
    public UserDto PatchUser(Long id, UserDto userDto) {
        UserEntity target = userRepository.findById(id).orElseThrow();

        return null;
    }

    @Override
    public UserDto DeleteUser(Long id) {
        UserEntity target = userRepository.findById(id).orElseThrow();

        userRepository.delete(target);

        return UserEntity.EntityToDto(target);
    }
    // 필요에 따라 다른 메서드들을 구현할 수 있습니다.
}
