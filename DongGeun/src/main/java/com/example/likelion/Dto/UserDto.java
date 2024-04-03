package com.example.likelion.Dto;

import com.example.likelion.Entity.UserEntity;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id; //회원번호. 자동생성

    private String uid; //아이디
    private String password; //비밀번호

    public static UserEntity DtoToEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .uid(userDto.getUid())
                .password(userDto.getPassword())
                .build();
    }
}
