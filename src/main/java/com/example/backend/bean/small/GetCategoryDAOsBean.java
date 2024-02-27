package com.example.backend.bean.small;

import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetCategoryDAOsBean {
    private final CategoryRepository categoryRepository;

    public List<CategoryEntity> exec(String username) {
        return new ArrayList<>(categoryRepository.findByUsername(username));
    }
}
