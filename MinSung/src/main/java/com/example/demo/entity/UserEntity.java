package com.example.demo.entity;

import com.example.demo.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uid;

    private String password;

    public static UserDto entityToDto(UserEntity userEntity){
        return UserDto.builder()
                .id(userEntity.getId())
                .uid(userEntity.getUid())
                .password(userEntity.getPassword())
                .build();
    }
}
