package com.example.backend.repository;

import com.example.backend.model.entity.RoutineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<RoutineEntity, Long> {
}
