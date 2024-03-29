package com.example.backend.model.entity;

import com.example.backend.model.dto.RequestCreateCategoryInput;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String category;
    private Long userId;

    private boolean isDeleted;

    @Builder
    public CategoryEntity(RequestCreateCategoryInput requestCreateCategoryInput) {
        this.userId = requestCreateCategoryInput.getUserId();
        this.category = requestCreateCategoryInput.getCategory();
        this.isDeleted = false;
    }

    public CategoryEntity(Long userId, String category) {
        this.userId = userId;
        this.category = category;
        this.isDeleted = false;
    }
}
