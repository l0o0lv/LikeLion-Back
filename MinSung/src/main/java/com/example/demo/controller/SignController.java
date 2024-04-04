package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likelion")
public class SignController {

    private final UserServiceImpl userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) {
        UserEntity user = userService.signup(userDto);
        UserDto newUser = UserEntity.entityToDto(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<UserDto> readUser(@PathVariable("id") Long id) {
        UserEntity user = userService.read(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(UserEntity.entityToDto(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        UserEntity updatedUser = userService.update(id, userDto);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(UserEntity.entityToDto(updatedUser));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") Long id) {
        boolean isDeleted = userService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }
}