package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestUserSignup {
    String email;
    String username;
    String password;
}
