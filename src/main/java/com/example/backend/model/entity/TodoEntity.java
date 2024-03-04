package com.example.backend.model.entity;

import com.example.backend.model.dto.RequestWriteTodoInput;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TodoEntity {
    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id;

    private String content;
    private int isCompleted;

    private LocalDate createdAt;
    private LocalDate finishedAt;

    private Long userId;
    private Long categoryId;

    @Builder
    public TodoEntity(RequestWriteTodoInput requestWriteTodoInput) {
        this.categoryId = requestWriteTodoInput.getCategoryId();
        this.content = requestWriteTodoInput.getContent();
        this.createdAt = LocalDate.parse(requestWriteTodoInput.getDate());
        this.userId = requestWriteTodoInput.getUserId();
        this.isCompleted = 0;
    }

    public TodoEntity(String content, Long categoryId, Long userId, String date) {
        this.content = content;
        this.userId = userId;
        this.categoryId = categoryId;
        this.createdAt = LocalDate.parse(date);
    }
}