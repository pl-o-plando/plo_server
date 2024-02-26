package com.example.backend.service;

import com.example.backend.bean.SaveTodoBean;
import com.example.backend.model.dto.RequestTodoInput;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final SaveTodoBean saveTodoBean;

    public TodoEntity saveTodoEntity(String username, RequestTodoInput requestTodoInput) {
        return saveTodoBean.exec(username, requestTodoInput);
    }
}