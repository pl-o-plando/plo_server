package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestModifyCategoryInput {
    Long categoryId;
    String category;
}
