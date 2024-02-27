package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestTodoInput;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModifyObjectDAOBean {
    private final TodoRepository todoRepository;

    public TodoEntity exec(TodoEntity todoEntity, RequestTodoInput requestTodoInput) {
        todoEntity.setCategory(requestTodoInput.getCategory());
        todoEntity.setContent(requestTodoInput.getContent());

        return todoEntity;
    }
}
