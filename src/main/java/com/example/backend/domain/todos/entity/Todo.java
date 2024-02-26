package com.example.backend.domain.todos.entity;

import com.example.backend.domain.BaseEntity;
import com.example.backend.domain.todos.dto.WriteTodoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
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
    private int isCompleted;

    private String username;

    @Builder
    public Todo(String username, WriteTodoDTO createTodoDTO) {
        this.category = createTodoDTO.getCategory();
        this.content = createTodoDTO.getContent();
        this.username = username;
        this.isCompleted = 0;
    }

    public void updateTodo(WriteTodoDTO updateTodoDTO) {
        this.category = updateTodoDTO.getCategory();
        this.content = updateTodoDTO.getContent();
        this.username = username;
    }
}