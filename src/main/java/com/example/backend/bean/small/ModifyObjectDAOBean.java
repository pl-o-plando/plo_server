package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestTodoInput;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ModifyObjectDAOBean {

    public TodoEntity exec(TodoEntity todoEntity, RequestTodoInput requestTodoInput) {
        todoEntity.setCategory(requestTodoInput.getCategory());
        todoEntity.setContent(requestTodoInput.getContent());
        todoEntity.setCreatedAt(LocalDate.parse(requestTodoInput.getDate()));

        return todoEntity;
    }
}
