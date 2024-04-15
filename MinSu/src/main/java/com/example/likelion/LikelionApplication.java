package com.example.likelion;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class LikelionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LikelionApplication.class, args);
    }

}
