package com.example.backend.bean;

import com.example.backend.bean.small.CheckDAOBean;
import com.example.backend.bean.small.NewObjectDAOBean;
import com.example.backend.bean.small.SaveDAOBean;
import com.example.backend.model.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveCategoryBean {
    private final SaveDAOBean saveDAOBean;
    private final NewObjectDAOBean newObjectDAOBean;

    public CategoryEntity exec(Long userId, String category) {

        CategoryEntity categoryEntity = newObjectDAOBean.exec(userId, category);
        saveDAOBean.exec(categoryEntity);

        return  categoryEntity;
    }
}
