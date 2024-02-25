package com.example.backend.domain.users.controller;

import com.example.backend.domain.users.dto.UserSignUpDto;
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
}
