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
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")); //회원번호로 검색하고 없을경우 RuntimeException을 던짐.
        return UserEntity.EntityToDto(userEntity); //검색한 회원 반환
    }

    @Override
    public List<UserDto> ReadAllUser() {
        return null;
    }

    @Override
    public UserDto PatchUser(Long id, UserDto userDto) {
        UserEntity target = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")); //회원번호로 검색하고 없을경우 RuntimeException을 던짐.

        target.setPassword(userDto.getPassword()); // 검색한 유저의 비밀번호 변경

//      if (userDto.getName() != null) { // 이름이 제공된 경우 업데이트
//            target.setName(userDto.getName());
//       }
//      if (userDto.getPassword() != null) { // 이메일이 제공된 경우 업데이트
//            target.setPassword(userDto.getPassword());
//       }

        userRepository.save(target); //수정된 회원 저장

        return UserEntity.EntityToDto(target); // 엔티티를 DTO로 변환하여 반환
    }

    @Override
    public UserDto DeleteUser(Long id) {
        UserEntity target = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")); //회원번호로 검색하고 없을경우 RuntimeException을 던짐.

        userRepository.delete(target); //검색한 회원 삭제

        return UserEntity.EntityToDto(target); // 삭제한 회원 알려주기 위해 반환
    }
}
