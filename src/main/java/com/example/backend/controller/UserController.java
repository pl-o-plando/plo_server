package com.example.backend.controller;

import com.example.backend.model.dto.RequestModifyTodoInput;
import com.example.backend.model.dto.RequestModifyUserInput;
import com.example.backend.model.dto.RequestUserInput;
import com.example.backend.model.dto.RequestUserSignup;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.model.entity.UserEntity;
import com.example.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "로그인", description = "로그인 성공 여부를 반환합니다.")
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody RequestUserInput requestUserInput) {
        // 로그인 유저 받기
        UserEntity userEntity = userService.loginUser(requestUserInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (userEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 User 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (userEntity != null) ? "Login Success" : "Login Fail");
        requestMap.put("user", userEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "회원가입", description = "회원가입 성공 여부를 반환합니다.")
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody RequestUserSignup requestUserSignup) {
        // 회원가입 정보 받기
        UserEntity userEntity = userService.signupUser(requestUserSignup);

        // HTTP 상태 반환
        HttpStatus httpStatus = (userEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 User 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (userEntity != null) ? "Signup Success" : "Signup Fail");
        requestMap.put("user", userEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "유저 수정", description = "유저 수정 성공 여부를 반환합니다.")
    @PostMapping("/user/modify")
    public ResponseEntity<Map<String, Object>> modifyUser(@RequestBody RequestModifyUserInput requestModifyUserInput) {
        // 회원가입 정보 받기
        UserEntity userEntity = userService.modifyUserEntity(requestModifyUserInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (userEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 할일 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (userEntity != null) ? "User Modify Success" : "User Modify Fail");
        requestMap.put("user", userEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
