package com.example.backend.bean;

import com.example.backend.bean.small.ChangeDAOBean;
import com.example.backend.bean.small.DeleteDAOBean;
import com.example.backend.bean.small.GetCategoryDAOBean;
import com.example.backend.bean.small.SaveDAOBean;
import com.example.backend.model.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCategoryBean {
    private final GetCategoryDAOBean getCategoryDAOBean;
    private final DeleteDAOBean deleteDAOBean;
    private final ChangeDAOBean changeDAOBean;
    private final SaveDAOBean saveDAOBean;

    public Long exec(Long categoryId) {
        CategoryEntity categoryEntity = getCategoryDAOBean.exec(categoryId);
        saveDAOBean.exec(changeDAOBean.exec(categoryEntity));
        deleteDAOBean.exec(categoryEntity);

        return categoryId;
    }
}
