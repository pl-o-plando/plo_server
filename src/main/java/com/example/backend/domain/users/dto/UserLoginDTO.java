package com.example.backend.domain.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserLoginDTO {
    private String email;
    private String password;
}