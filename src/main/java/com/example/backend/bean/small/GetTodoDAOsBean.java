package com.example.backend.bean.small;

import com.example.backend.model.entity.TodoEntity;
import com.example.backend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetTodoDAOsBean {
    private final TodoRepository todoRepository;

    public List<TodoEntity> exec(String username) {
        return new ArrayList<>(todoRepository.findByUsername(username));
    }
}
