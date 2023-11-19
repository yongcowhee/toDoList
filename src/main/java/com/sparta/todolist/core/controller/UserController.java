package com.sparta.todolist.core.controller;

import com.sparta.todolist.core.dto.SignUpRequestDto;
import com.sparta.todolist.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        userService.signUp(signUpRequestDto);
        return ResponseEntity.ok("성공");
    }
}
