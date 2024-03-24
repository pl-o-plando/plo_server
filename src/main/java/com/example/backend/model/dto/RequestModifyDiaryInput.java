package com.example.backend.model.dto;

import lombok.Data;

@Data
public class RequestModifyDiaryInput {
    Long diaryId;
    String feel;
    String content;
}
