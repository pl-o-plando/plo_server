package com.example.backend.bean.small;

import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetCategoryDAOBean {
    private final CategoryRepository categoryRepository;

    public CategoryEntity exec(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
}
