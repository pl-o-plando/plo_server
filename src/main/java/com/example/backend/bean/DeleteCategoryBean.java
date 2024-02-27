package com.example.backend.bean;

import com.example.backend.bean.small.DeleteDAOBean;
import com.example.backend.bean.small.GetCategoryDAOBean;
import com.example.backend.model.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCategoryBean {
    private final GetCategoryDAOBean getCategoryDAOBean;
    private final DeleteDAOBean deleteDAOBean;

    public Long exec(Long categoryId) {
        CategoryEntity categoryEntity = getCategoryDAOBean.exec(categoryId);

        deleteDAOBean.exec(categoryEntity);

        return categoryId;
    }
}
