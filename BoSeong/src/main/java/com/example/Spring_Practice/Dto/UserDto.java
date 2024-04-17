package com.example.Spring_Practice.Dto;

import com.example.Spring_Practice.Entity.UserEntity;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String uid;
    private String password;
    private String nickname;
    private Long score;

    public static UserEntity DtoToEntity(UserDto userDto){
        return UserEntity.builder()
                .id(userDto.getId())
                .uid(userDto.getUid())
                .password(userDto.getPassword())
                .nickname(userDto.getNickname())
                .score(userDto.getScore())
                .build();
    }
}
