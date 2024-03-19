package com.example.backend.service;

import com.example.backend.bean.*;
import com.example.backend.model.dto.RequestChangeStateTodoInput;
import com.example.backend.model.dto.RequestModifyTodoInput;
import com.example.backend.model.dto.RequestWriteTodoInput;
import com.example.backend.model.dto.ResponseSearchTodoByUserAndDate;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final SaveTodoBean saveTodoBean;
    private final DeleteTodoBean deleteTodoBean;
    private final ModifyTodoBean modifyTodoBean;
    private final ShowTodoBean showTodoBean;
    private final ChangeStateTodoBean changeStateTodoBean;

    public TodoEntity saveTodoEntity(RequestWriteTodoInput requestWriteTodoInput) {
        return saveTodoBean.exec(requestWriteTodoInput);
    }

    public TodoEntity modifyTodoEntity(RequestModifyTodoInput requestModifyTodoInput) {
        return modifyTodoBean.exec(requestModifyTodoInput);
    }

    public Long deleteTodoEntity(Long todoId) {
        return deleteTodoBean.exec(todoId);
    }

    public List<TodoEntity> getTodoEntityByUser(Long userId) {
        return showTodoBean.exec(userId);
    }

    public ResponseSearchTodoByUserAndDate getTodoEntityByDate(Long userId, LocalDate date) {
        return showTodoBean.exec(userId, date);
    }

    public TodoEntity changeStateTodoEntity(RequestChangeStateTodoInput requestChangeStateTodoInput) {
        return changeStateTodoBean.exec(requestChangeStateTodoInput);
    }
}