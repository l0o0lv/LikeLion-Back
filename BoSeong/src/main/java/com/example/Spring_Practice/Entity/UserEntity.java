package com.example.Spring_Practice.Entity;

import com.example.Spring_Practice.Dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uid;
    private String password;
    private String nickname;
    private Long score;

    public static UserDto EntityToDto(UserEntity userEntity){
        return UserDto.builder()
                .id(userEntity.getId())
                .uid(userEntity.getUid())
                .password(userEntity.getPassword())
                .nickname(userEntity.getNickname())
                .score(userEntity.getScore())
                .build();
    }
}
