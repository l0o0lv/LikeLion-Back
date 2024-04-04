package com.example.likelion.Dto;

import com.example.likelion.Entity.UserEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;    // 회원번호, 자동생성

    @NotNull(message = "값을 입력해주세요.")
    private String uid; // 아이디
    @Size(min = 6, max = 10, message = "비밀번호는 6자 이상 10자 미만으로 입력해주세요.")
    private String password; // 비밀번호

    public static UserEntity DtoToEntity(UserDto userDto){
        return UserEntity.builder()
                .id(userDto.getId())
                .uid(userDto.getUid())
                .password(userDto.getPassword())
                .build();
    }
}
