package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestModifyTodoInput {
    Long userId;
    Long todoId;
    String category;
    String content;
    String date;
}
