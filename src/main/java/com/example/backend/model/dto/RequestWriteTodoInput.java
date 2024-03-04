package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestWriteTodoInput {
    Long userId;
    Long categoryId;
    String content;
    String date;
}
