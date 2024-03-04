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
    private final CheckDAOBean checkDAOBean;
    private final SaveDAOBean saveDAOBean;
    private final NewObjectDAOBean newObjectDAOBean;

    public CategoryEntity exec(String username, String category) {

        CategoryEntity categoryEntity = newObjectDAOBean.exec(username, category);
        saveDAOBean.exec(categoryEntity);

        return  categoryEntity;
    }
}
