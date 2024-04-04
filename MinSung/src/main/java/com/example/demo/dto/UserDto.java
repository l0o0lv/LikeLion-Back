package com.example.demo.dto;

import com.example.demo.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private Long id;
    private String uid;
    private String password;

    public static UserEntity dtoToEntity(UserDto userDto){
        return UserEntity.builder()
                .id(userDto.getId())
                .password(userDto.getPassword())
                .uid(userDto.getUid())
                .build();
    }
}
