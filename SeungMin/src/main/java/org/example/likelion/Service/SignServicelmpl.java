package org.example.likelion.Service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.likelion.Dto.UserDto;
import org.example.likelion.Entity.UserEntity;
import org.example.likelion.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignServicelmpl implements SignService{

    private final UserRepository userRespository;

    @Autowired
    public SignServicelmpl(UserRepository userResponsitory){
        this.userRespository = userResponsitory;
    }
    @Override
    public UserDto SignUp(UserDto userDto){
        // DTO를 Entity로 변환
        UserEntity userEntity = UserDto.DtoToEntity(userDto);

        // DB에 저장
        userRespository.save(userEntity);

        return UserEntity.EntityToDto(userEntity);
    }

    @Override
    public UserDto getUserById(Long id){
        UserEntity userEntity = userRespository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserEntity.EntityToDto(userEntity);
    }

    @Override
    public List<UserDto> ReadAllUser(){
        return null;
    }

    @Override
    public UserDto PatchUser(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public UserDto DeleteUser(Long id){
        return null;
    }
    // 필요에 따라 다른 메서드를 구현할 수 있습니다


}
