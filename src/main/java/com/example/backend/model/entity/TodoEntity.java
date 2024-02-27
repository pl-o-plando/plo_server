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
public class TodoEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id;

    private String content;
    private String category;
    private int isCompleted;

    private String username;

    @Builder
    public TodoEntity(String username, RequestTodoInput requestTodoInput) {
        this.category = requestTodoInput.getCategory();
        this.content = requestTodoInput.getContent();
        this.username = username;
        this.isCompleted = 0;
    }

    public TodoEntity(String content, String category, String username) {
        this.content = content;
        this.username = username;
        this.category = category;
    }
}