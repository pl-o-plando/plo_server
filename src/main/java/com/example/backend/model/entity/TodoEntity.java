package com.example.backend.model.entity;

import com.example.backend.model.dto.WriteTodoDTO;
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
    public TodoEntity(String username, WriteTodoDTO createTodoDTO) {
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