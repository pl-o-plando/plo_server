package com.example.backend.repository;

import com.example.backend.model.entity.RoutineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutineRepository extends JpaRepository<RoutineEntity, Long> {
    List<RoutineEntity> findByCategoryId(Long categoryId);
}
