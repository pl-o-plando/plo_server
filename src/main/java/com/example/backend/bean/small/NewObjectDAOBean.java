package com.example.backend.bean.small;

import com.example.backend.model.dto.*;
import com.example.backend.model.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    // 투두 조회 객체 생성
    public ResponseSearchTodoByUserAndDate exec(Long userId, LocalDate date, List<ResponseTodoByCategory> list) {
        ResponseSearchTodoByUserAndDate responseSearchTodoByUserAndDate = new ResponseSearchTodoByUserAndDate();
        responseSearchTodoByUserAndDate.setUserId(userId);
        responseSearchTodoByUserAndDate.setSearchDate(date);
        responseSearchTodoByUserAndDate.setCategoryList(list);

        return responseSearchTodoByUserAndDate;
    }

    // 카테고리별 투두 조회 객체 생성
    public ResponseTodoByCategory exec(CategoryEntity categoryEntity) {
        ResponseTodoByCategory responseTodoByCategory = new ResponseTodoByCategory();
        responseTodoByCategory.setCategoryId(categoryEntity.getId());
        responseTodoByCategory.setCategory(categoryEntity.getCategory());
        responseTodoByCategory.setTodoList(new ArrayList<>());

        return responseTodoByCategory;
    }

    // 간단 추두 정보 객체 생성
    public ResponseSimpleTodo exec(TodoEntity todoEntity) {
        ResponseSimpleTodo responseSimpleTodo = new ResponseSimpleTodo();
        responseSimpleTodo.setTodoId(todoEntity.getId());
        responseSimpleTodo.setContent(todoEntity.getContent());

        return responseSimpleTodo;
    }
}