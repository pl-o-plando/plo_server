package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestModifyTodoInput {
    Long userId;
    Long todoId;
    Long categoryId;
    String content;
    String date;
}
