package com.example.backend.bean.small;

import com.example.backend.model.entity.*;
import com.example.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveDAOBean {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;
    private final RoutineRepository routineRepository;
    private final DeleteCategoryRepository deleteCategoryRepository;

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

    // 삭제된 카테고리 저장
    public void exec(DeleteCategoryEntity deleteCategoryEntity) { deleteCategoryRepository.save(deleteCategoryEntity); }
}