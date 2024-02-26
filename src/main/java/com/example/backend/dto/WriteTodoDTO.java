package com.example.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WriteTodoDTO {
    String category;
    String content;
}