package com.example.backend.service;

import com.example.backend.bean.SaveCategoryBean;
import com.example.backend.model.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final SaveCategoryBean saveCategoryBean;

    public CategoryEntity saveCategoryEntity(String username, String category) {
        return saveCategoryBean.exec(username, category);
    }
}
