package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestModifyCategoryInput;
import com.example.backend.model.dto.RequestModifyRoutineInput;
import com.example.backend.model.dto.RequestModifyTodoInput;
import com.example.backend.model.dto.RequestModifyUserInput;
import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.RoutineEntity;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ModifyObjectDAOBean {

    // 투두 객체의 값을 변경
    public TodoEntity exec(TodoEntity todoEntity, RequestModifyTodoInput requestModifyTodoInput) {
        todoEntity.setCategoryId(requestModifyTodoInput.getCategoryId());
        todoEntity.setContent(requestModifyTodoInput.getContent());
        todoEntity.setCreatedAt(LocalDate.parse(requestModifyTodoInput.getDate()));

        return todoEntity;
    }

    // 투두 객체의 상태 변경
    public TodoEntity exec(TodoEntity todoEntity, int isCompleted) {
        todoEntity.setIsCompleted(isCompleted);

        return todoEntity;
    }

    // 유저 객체의 값을 변경
    public UserEntity exec(UserEntity userEntity, RequestModifyUserInput requestModifyUserInput) {
        userEntity.setUsername(requestModifyUserInput.getUsername());
        userEntity.setPassword(requestModifyUserInput.getPassword());
        userEntity.setResolution(requestModifyUserInput.getResolution());

        return userEntity;
    }

    // 카테고리 객체의 값을 변경
    public CategoryEntity exec(CategoryEntity categoryEntity, RequestModifyCategoryInput requestModifyCategoryInput) {
        categoryEntity.setCategory(requestModifyCategoryInput.getCategory());

        return categoryEntity;
    }

    // 루틴 객체의 값을 변경
    public RoutineEntity exec(RoutineEntity routineEntity, RequestModifyRoutineInput requestModifyRoutineInput) {
        routineEntity.setRoutine(requestModifyRoutineInput.getRoutine());

        return routineEntity;
    }
}
