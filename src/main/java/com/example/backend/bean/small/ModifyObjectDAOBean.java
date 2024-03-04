package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestModifyTodoInput;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ModifyObjectDAOBean {

    public TodoEntity exec(TodoEntity todoEntity, RequestModifyTodoInput requestModifyTodoInput) {
        todoEntity.setCategoryId(requestModifyTodoInput.getCategoryId());
        todoEntity.setContent(requestModifyTodoInput.getContent());
        todoEntity.setCreatedAt(LocalDate.parse(requestModifyTodoInput.getDate()));

        return todoEntity;
    }

    public TodoEntity exec(TodoEntity todoEntity, int isCompleted) {
        todoEntity.setIsCompleted(isCompleted);

        return todoEntity;
    }
}
