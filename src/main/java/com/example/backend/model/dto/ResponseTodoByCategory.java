package com.example.backend.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseTodoByCategory {
    String category;
    List<ResponseSimpleTodo> todoList;
}