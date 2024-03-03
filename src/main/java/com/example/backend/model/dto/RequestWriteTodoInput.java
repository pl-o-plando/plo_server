package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestWriteTodoInput {
    Long userId;
    String category;
    String content;
    String date;
}
