package com.example.backend.bean.small;

import com.example.backend.model.entity.TodoEntity;
import com.example.backend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetTodoDAOBean {
    private final TodoRepository todoRepository;

    public TodoEntity exec(Long todoId) {
        return todoRepository.findById(todoId).get();
    }
}
