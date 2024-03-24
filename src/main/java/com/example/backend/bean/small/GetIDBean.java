package com.example.backend.bean.small;

import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetIDBean {
    public Set<Long> exec(List<TodoEntity> todoEntityList) {
        return todoEntityList.stream()
                .map(TodoEntity::getCategoryId)
                .collect(Collectors.toSet());
    }
}