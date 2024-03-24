package com.example.backend.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseTodoByCategory {
    Long categoryId;
    String category;
    boolean isDeleted;
    List<ResponseSimpleTodo> todoList;
}