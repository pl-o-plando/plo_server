package com.example.backend.repository;

import com.example.backend.model.entity.DeleteCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeleteCategoryRepository extends JpaRepository<DeleteCategoryEntity, Long> {
}
