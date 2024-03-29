package com.example.backend.bean;

import com.example.backend.bean.small.GetCategoryDAOsBean;
import com.example.backend.model.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowCategoryBean {
    private final GetCategoryDAOsBean getCategoryDAOsBean;
    public List<CategoryEntity> exec(Long userId) {
        return getCategoryDAOsBean.exec(userId);
    }

    public List<CategoryEntity> exec(Long userId, boolean flag) { return getCategoryDAOsBean.exec(userId, flag); }
}
