package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestWriteTodoInput;
import com.example.backend.model.dto.RequestUserSignup;
import com.example.backend.model.entity.CategoryEntity;
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
                                    .requestTodoInput(requestWriteTodoInput)
                                    .build();
        return todoEntity;
    }

    // 카테고리 객체 생성
    public CategoryEntity exec(String username, String category) {
        CategoryEntity categoryEntity = CategoryEntity.builder()
                                            .username(username)
                                            .category(category)
                                            .build();
        return  categoryEntity;
    }
}