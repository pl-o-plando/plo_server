package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestWriteTodoInput;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ModifyObjectDAOBean {

    public TodoEntity exec(TodoEntity todoEntity, RequestWriteTodoInput requestWriteTodoInput) {
        todoEntity.setCategory(requestWriteTodoInput.getCategory());
        todoEntity.setContent(requestWriteTodoInput.getContent());
        todoEntity.setCreatedAt(LocalDate.parse(requestWriteTodoInput.getDate()));

        return todoEntity;
    }

    public TodoEntity exec(TodoEntity todoEntity, int isCompleted) {
        todoEntity.setIsCompleted(isCompleted);

        return todoEntity;
    }
}
