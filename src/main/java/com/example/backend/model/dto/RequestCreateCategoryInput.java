package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestCreateCategoryInput {
    Long userId;
    String category;
}
