package com.example.backend.domain.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSignUpDto {
    private String email;
    private String username;
    private String password;
    private String re_password;
}