package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestChangeStateTodoInput {
    Long todoId;
    int isCompleted;
}
