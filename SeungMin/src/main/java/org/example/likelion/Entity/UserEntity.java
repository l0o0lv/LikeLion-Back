package org.example.likelion.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.likelion.Dto.UserDto;

import java.security.PublicKey;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 DB에 위임. AUTO_INCREMENT
    private Long id; //회원번호. 자동생성

    private String uid; //아이디
    private String password; //비밀번호

    public static UserDto EntityToDto(UserEntity userEntity){
        return UserDto.builder()
                .id(userEntity.getId())
                .uid(userEntity.getUid())
                .password(userEntity.getPassword())
                .build();

    }
}
