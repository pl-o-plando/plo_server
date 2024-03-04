package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestModifyUserInput {
    Long userId;
    String username;
    String password;
    String resolution;
}
