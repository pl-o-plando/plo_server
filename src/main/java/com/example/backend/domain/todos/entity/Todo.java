package com.example.backend.domain.todos.entity;

import com.example.backend.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id;

    private String content;
    private String category;
    private boolean isCompleted;

}