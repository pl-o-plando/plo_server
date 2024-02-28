package com.example.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id;

    private String category;
    private String username;

    @Builder
    public CategoryEntity(String username, String category) {
        this.username = username;
        this.category = category;
    }
}
