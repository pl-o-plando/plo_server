package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestTodoInput {
    String category;
    String content;
    String date;
}
