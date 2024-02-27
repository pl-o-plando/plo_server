package com.example.backend.service;

import com.example.backend.bean.DeleteTodoBean;
import com.example.backend.bean.ModifyTodoBean;
import com.example.backend.bean.SaveTodoBean;
import com.example.backend.bean.ShowTodoBean;
import com.example.backend.model.dto.RequestTodoInput;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final SaveTodoBean saveTodoBean;
    private final DeleteTodoBean deleteTodoBean;
    private final ModifyTodoBean modifyTodoBean;
    private final ShowTodoBean showTodoBean;

    public TodoEntity saveTodoEntity(String username, RequestTodoInput requestTodoInput) {
        return saveTodoBean.exec(username, requestTodoInput);
    }

    public TodoEntity modifyTodoEntity(String username, Long userId, RequestTodoInput requestTodoInput) {
        return modifyTodoBean.exec(username, userId, requestTodoInput);
    }

    public Long deleteTodoEntity(String username, Long todoId) {
        return deleteTodoBean.exec(username, todoId);
    }

    public List<TodoEntity> getByUserTodosEntity(String username) {
        return showTodoBean.exec(username);
    }

    public List<TodoEntity> getByDateTodosEntity(String username, LocalDate date) {
        return showTodoBean.exec(username, date);
    }
}