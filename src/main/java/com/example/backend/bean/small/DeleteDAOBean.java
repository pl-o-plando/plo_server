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
public class DeleteDAOBean {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;
    private final RoutineRepository routineRepository;

    // 유저 삭제
    public void exec(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    // 할일 삭제
    public void exec(TodoEntity todoEntity) {
        todoEntity.setDeleted(true);
        todoRepository.save(todoEntity);
    }

    // 카테고리 삭제
    public void exec(CategoryEntity categoryEntity) {
        categoryEntity.setDeleted(true);
        categoryRepository.save(categoryEntity);
    }

    // 루틴 삭제
    public void exec(RoutineEntity routineEntity) { routineRepository.delete(routineEntity); }
}
