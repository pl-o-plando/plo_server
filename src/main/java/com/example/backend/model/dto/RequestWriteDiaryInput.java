package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestWriteDiaryInput {
    Long userId;
    String feel;
    String content;
    String date;
}
