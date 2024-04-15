package com.example.likelion.Controller;

import com.example.likelion.Dto.UserDto;
import com.example.likelion.Service.SignService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likelion")  // 모든 핸들러 메서드의 기본 URL 경로 설정
public class SignController {
    private final SignService signService;

    public SignController(@Autowired SignService signService ){  // 의존성 주입
        this.signService = signService;
    }

    // ResponseEntity : HTTP 응답을 구성할 때 사용. 상태 코드, 헤더, 응답 본문 등을 포함할 수 있음.
    // @RequestBody : HTTP 요청의 본문을 자바 객체로 변환하여 메서드의 매개변수로 전달할 때 사용
    @PostMapping("/signup") //회원가입 . CREATE
    public ResponseEntity<UserDto> SignUp(@RequestBody @Valid UserDto userDto){
        UserDto createUser = signService.SignUp(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser); // CREATED : 201
    }

    // @PathVariable : URL 경로의 일부를 메서드의 매개변수로 바인딩할 때 사용
    @GetMapping("/user/{id}") // 회원번호로 회원조회 . READ
    public ResponseEntity<UserDto> ReadAllUser(@PathVariable("id") Long id){
        UserDto userDto = signService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userDto); // OK : 200
    }

    //
    @PatchMapping("/patch/{id}")    // 회원수정 . UPDATE
    public ResponseEntity<UserDto> UpdateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        UserDto updateUser = signService.UpdateUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateUser); // OK : 200
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteUser(@PathVariable("id") Long id){
        signService.DeleteUser(id);
    }
}
