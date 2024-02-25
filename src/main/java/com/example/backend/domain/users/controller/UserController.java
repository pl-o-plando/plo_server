package com.example.backend.domain.users.controller;

import com.example.backend.domain.users.dto.UserLoginDto;
import com.example.backend.domain.users.dto.UserSignUpDto;
import com.example.backend.domain.users.entity.User;
import com.example.backend.domain.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원가입", description = "회원가입 성공 여부를 반환합니다.")
    @PostMapping("/sign_up")
    public String signUp(@RequestBody UserSignUpDto userSignUpDto) throws Exception {
        userService.signUp(userSignUpDto);

        return "회원가입 성공";
    }

    @Operation(summary = "로그인", description = "로그인 성공 여부를 반환합니다.")
    @PostMapping("/login")
    public User login(@RequestBody UserLoginDto userLoginDto) throws Exception {
        return userService.login(userLoginDto);
    }
}
