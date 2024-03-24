package com.example.backend.bean.small;

import com.example.backend.model.dto.ResponseSimpleTodo;
import com.example.backend.model.dto.ResponseTodoByCategory;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChangeDAOBean {
    private final NewObjectDAOBean newObjectDAOBean;
    private final GetCategoryDAOBean getCategoryDAOBean;

    public List<ResponseTodoByCategory> exec(Set<Long> list) {
        return list.stream()
                .map(id -> newObjectDAOBean.exec(getCategoryDAOBean.exec(id)))
                .collect(Collectors.toList());
    }

    public List<ResponseSimpleTodo> exec(List<TodoEntity> list) {
        return list.stream()
                .map(todoEntity -> newObjectDAOBean.exec(todoEntity))
                .collect(Collectors.toList());
    }
}