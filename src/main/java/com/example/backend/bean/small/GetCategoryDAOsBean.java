package com.example.backend.bean.small;

import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetCategoryDAOsBean {
    private final CategoryRepository categoryRepository;

    public List<CategoryEntity> exec(Long userId) {
        return new ArrayList<>(categoryRepository.findByUserId(userId));
    }

    public List<CategoryEntity> exec(Long userId, boolean flag) {
        return new ArrayList<>(categoryRepository.findByUserId(userId)
                                                    .stream()
                                                    .filter(CategoryEntity -> CategoryEntity.isDeleted() == flag)
                                                    .collect(Collectors.toList()));
    }
}
