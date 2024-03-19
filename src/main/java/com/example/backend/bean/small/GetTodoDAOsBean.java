package com.example.backend.bean.small;

import com.example.backend.model.entity.TodoEntity;
import com.example.backend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetTodoDAOsBean {
    private final TodoRepository todoRepository;

    public List<TodoEntity> exec(Long userId) {
        return new ArrayList<>(todoRepository.findByUserId(userId));
    }

    public List<TodoEntity> exec(Long userId, LocalDate date) {
        return new ArrayList<>(todoRepository.findByUserIdAndCreatedAt(userId, date));
    }

    public List<TodoEntity> exec(Long userId, Long categoryId, LocalDate date) {
        return new ArrayList<>(todoRepository.findByUserIdAndCategoryIdAndCreatedAt(userId, categoryId, date));
    }
}
