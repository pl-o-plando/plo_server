package com.example.backend.bean.small;

import com.example.backend.model.entity.TodoEntity;
import com.example.backend.model.entity.UserEntity;
import com.example.backend.repository.TodoRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteDAOBean {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    // 유저 삭제
    public void exec(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    // 할일 삭제
    public void exec(TodoEntity todoEntity) {
        todoRepository.delete(todoEntity);
    }
}
