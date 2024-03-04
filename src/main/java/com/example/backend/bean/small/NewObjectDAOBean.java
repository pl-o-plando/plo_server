package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestCreateCategoryInput;
import com.example.backend.model.dto.RequestCreateRoutineInput;
import com.example.backend.model.dto.RequestWriteTodoInput;
import com.example.backend.model.dto.RequestUserSignup;
import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.RoutineEntity;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewObjectDAOBean {
    // 유저 객체 생성
    public UserEntity exec(RequestUserSignup requestUserSignup) {
        UserEntity userEntity = UserEntity.builder()
                                    .requestUserSignup(requestUserSignup)
                                    .build();

        return userEntity;
    }

    // 할일 객체 생성
    public TodoEntity exec(RequestWriteTodoInput requestWriteTodoInput) {
        TodoEntity todoEntity = TodoEntity.builder()
                                    .requestWriteTodoInput(requestWriteTodoInput)
                                    .build();
        return todoEntity;
    }

    // 카테고리 객체 생성
    public CategoryEntity exec(RequestCreateCategoryInput requestCreateCategoryInput) {
        CategoryEntity categoryEntity = CategoryEntity.builder()
                                            .requestCreateCategoryInput(requestCreateCategoryInput)
                                            .build();
        return  categoryEntity;
    }

    // 기본 카테고리 객체 생성
    public CategoryEntity exec(Long userId, String category) {
        CategoryEntity categoryEntity = new CategoryEntity(userId, category);

        return  categoryEntity;
    }

    // 루틴 객체 생성
    public RoutineEntity exec(RequestCreateRoutineInput requestCreateRoutineInput) {
        RoutineEntity routineEntity = RoutineEntity.builder()
                                            .requestCreateRoutineInput(requestCreateRoutineInput)
                                            .build();
        return routineEntity;
    }
}