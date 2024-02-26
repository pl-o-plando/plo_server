package com.example.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSignUpDTO {
    private String email;
    private String username;
    private String password;
    private String re_password;
}