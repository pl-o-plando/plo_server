package com.example.backend.model.entity;

import com.example.backend.model.dto.RequestTodoInput;
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

    private String category;
    private String content;
    private int isCompleted;

    private LocalDate createdAt;
    private LocalDate finishedAt;

    private Long userId;

    @Builder
    public TodoEntity(RequestTodoInput requestTodoInput) {
        this.category = requestTodoInput.getCategory();
        this.content = requestTodoInput.getContent();
        this.createdAt = LocalDate.parse(requestTodoInput.getDate());
        this.userId = requestTodoInput.getUserId();
        this.isCompleted = 0;
    }

    public TodoEntity(String content, String category, Long userId, String date) {
        this.content = content;
        this.userId = userId;
        this.category = category;
        this.createdAt = LocalDate.parse(date);
    }
}