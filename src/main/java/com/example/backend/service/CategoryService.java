package com.example.backend.service;

import com.example.backend.bean.DeleteCategoryBean;
import com.example.backend.bean.ModifyCategoryBean;
import com.example.backend.bean.SaveCategoryBean;
import com.example.backend.bean.ShowCategoryBean;
import com.example.backend.model.dto.RequestCreateCategoryInput;
import com.example.backend.model.dto.RequestModifyCategoryInput;
import com.example.backend.model.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final SaveCategoryBean saveCategoryBean;
    private final DeleteCategoryBean deleteCategoryBean;
    private final ShowCategoryBean showCategoryBean;
    private final ModifyCategoryBean modifyCategoryBean;

    public CategoryEntity saveCategoryEntity(RequestCreateCategoryInput requestCreateCategoryInput) {
        return saveCategoryBean.exec(requestCreateCategoryInput);
    }

    public Long deleteCategoryEntity(Long categoryId) {
        return deleteCategoryBean.exec(categoryId);
    }

    public List<CategoryEntity> getCategoryEntityByUserId(Long userId, boolean flag) {
        return showCategoryBean.exec(userId, flag);
    }

    public List<CategoryEntity> getAllCategoryEntityByUserId(Long userId) {
        return showCategoryBean.exec(userId);
    }

    public CategoryEntity modifyCategoryEntity(RequestModifyCategoryInput requestModifyCategoryInput) {
        return modifyCategoryBean.exec(requestModifyCategoryInput);
    }
}
