package com.example.backend.bean;

import com.example.backend.bean.small.*;
import com.example.backend.model.dto.ResponseSearchTodoByUserAndDate;
import com.example.backend.model.dto.ResponseTodoByCategory;
import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ShowTodoBean {
    private final GetTodoDAOsBean getTodoDAOsBean;
    private final NewObjectDAOBean newObjectDAOBean;
    private final GetCategoryDAOsBean getCategoryDAOsBean;
    private final ChangeDAOBean changeDAOBean;
    private final GetIDBean getIDBean;

    public List<TodoEntity> exec(Long userId) {
        return getTodoDAOsBean.exec(userId);
    }

    public ResponseSearchTodoByUserAndDate exec(Long userId, LocalDate date) {
        Set<Long> categoryIdList = getIDBean.exec(getTodoDAOsBean.exec(userId, date));
        categoryIdList.addAll(getCategoryDAOsBean.exec(userId)
                                                    .stream()
                                                    .filter(categoryEntity -> !categoryEntity.isDeleted())
                                                    .map(CategoryEntity::getId)
                                                    .collect(Collectors.toList()));

        List<ResponseTodoByCategory> responseTodoByCategoryList = changeDAOBean.exec(categoryIdList);

        for(ResponseTodoByCategory responseTodoByCategory : responseTodoByCategoryList) {
            responseTodoByCategory.getTodoList()
                    .addAll(changeDAOBean.exec(getTodoDAOsBean.exec(userId, responseTodoByCategory.getCategoryId(), date)));
        }

        return newObjectDAOBean.exec(userId, date, responseTodoByCategoryList);
    }
}