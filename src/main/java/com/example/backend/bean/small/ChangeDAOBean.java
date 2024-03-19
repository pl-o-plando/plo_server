package com.example.backend.bean.small;

import com.example.backend.model.dto.ResponseSimpleTodo;
import com.example.backend.model.dto.ResponseTodoByCategory;
import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChangeDAOBean {
    private final NewObjectDAOBean newObjectDAOBean;

    public List<ResponseTodoByCategory> execCategory(List<CategoryEntity> list) {
        return list.stream()
                .map(categoryEntity -> newObjectDAOBean.exec(categoryEntity))
                .collect(Collectors.toList());
    }

    public List<ResponseSimpleTodo> execTodo(List<TodoEntity> list) {
        return list.stream()
                .map(todoEntity -> newObjectDAOBean.exec(todoEntity))
                .collect(Collectors.toList());
    }
}