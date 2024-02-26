package com.example.backend.domain.users.controller;

import com.example.backend.domain.ErrorResponse;
import com.example.backend.domain.users.dto.UserLoginDTO;
import com.example.backend.domain.users.dto.UserSignUpDTO;
import com.example.backend.domain.users.entity.User;
import com.example.backend.domain.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원가입", description = "회원가입 성공 여부를 반환합니다.")
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpDTO userSignUpDTO) {
        try {
            User createdUser = userService.signUp(userSignUpDTO);

            // 회원가입 성공 시 사용자 정보 반환
            return ResponseEntity.ok(createdUser);
        } catch (Exception e) {

            // 회원가입 실패 시 400 Bad Request 반환
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @Operation(summary = "로그인", description = "로그인 성공 여부를 반환합니다.")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            User loginUser = userService.login(userLoginDTO);

            // 로그인 성공 시 사용자 정보 반환
            return ResponseEntity.ok(loginUser);
        } catch (Exception e) {

            // 로그인 실패 시 401 Unauthorized 반환
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
