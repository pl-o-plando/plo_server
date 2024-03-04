package com.example.backend.repository;

import com.example.backend.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByUserId(Long UserId);

    List<TodoEntity> findByUserIdAndCreatedAt(Long UserId, LocalDate CreatedAt);
}
