package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestTodoInput;
import com.example.backend.model.dto.RequestUserSignup;
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
    public TodoEntity exec(String username, RequestTodoInput requestTodoInput) {
        TodoEntity todoEntity = TodoEntity.builder()
                                    .requestTodoInput(requestTodoInput)
                                    .username(username)
                                    .build();
        return todoEntity;
    }
}