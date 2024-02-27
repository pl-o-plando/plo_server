package com.example.backend.repository;

import com.example.backend.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByUsername(String Username);
}
