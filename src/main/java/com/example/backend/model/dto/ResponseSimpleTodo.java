package com.example.backend.model.dto;

import lombok.Data;

@Data
public class ResponseSimpleTodo {
    Long todoId;
    String content;
}