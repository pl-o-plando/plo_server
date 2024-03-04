package com.example.backend.bean.small;

import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.RoutineEntity;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.model.entity.UserEntity;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.RoutineRepository;
import com.example.backend.repository.TodoRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveDAOBean {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;
    private final RoutineRepository routineRepository;

    // 유저 저장
    public void exec(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    // 할일 저장
    public void exec(TodoEntity todoEntity) { todoRepository.save(todoEntity); }

    // 카테고리 저장
    public void exec(CategoryEntity categoryEntity) { categoryRepository.save(categoryEntity); }

    // 루틴 저장
    public void exec(RoutineEntity routineEntity) { routineRepository.save(routineEntity); }
}