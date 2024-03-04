package com.example.backend.bean;

import com.example.backend.bean.small.NewObjectDAOBean;
import com.example.backend.bean.small.SaveDAOBean;
import com.example.backend.model.dto.RequestCreateCategoryInput;
import com.example.backend.model.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveCategoryBean {
    private final SaveDAOBean saveDAOBean;
    private final NewObjectDAOBean newObjectDAOBean;

    public CategoryEntity exec(RequestCreateCategoryInput requestCreateCategoryInput) {

        CategoryEntity categoryEntity = newObjectDAOBean.exec(requestCreateCategoryInput);
        saveDAOBean.exec(categoryEntity);

        return  categoryEntity;
    }
}
