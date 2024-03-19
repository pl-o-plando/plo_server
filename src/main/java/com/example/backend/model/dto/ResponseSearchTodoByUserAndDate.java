package com.example.backend.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ResponseSearchTodoByUserAndDate {
    Long userId;
    LocalDate searchDate;
    List<ResponseTodoByCategory> categoryList;
}
