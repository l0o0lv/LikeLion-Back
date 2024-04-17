package com.example.Spring_Practice.Controller;

import com.example.Spring_Practice.Dto.UserDto;
import com.example.Spring_Practice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //JSON으로 보내기
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto newUser = userService.createUser(userDto);
        return ResponseEntity.ok(newUser);
    }

    //RequestParam - 주소 뒤에 붙는 파라미터
    // ex) login?uid=123&password=1234
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String uid, @RequestParam String password) {
        System.out.println(uid + " " + password);
        UserDto user = userService.login(uid, password);
        return ResponseEntity.ok("OK, " + user.getNickname());
    }

    @GetMapping("/{id}")
    public int test(
            @PathVariable("id") int id
    ){
        return id;
    }
}
