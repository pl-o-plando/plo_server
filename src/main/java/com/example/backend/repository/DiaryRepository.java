package com.example.backend.repository;

import com.example.backend.model.entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {
    List<DiaryEntity> findByUserIdAndCreatedAt(Long UserId, LocalDate CreatedAt);
}
