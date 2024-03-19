package com.example.backend.model.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class DeleteCategoryEntity {
    private Long id;
    private String category;
    private Long userId;
}