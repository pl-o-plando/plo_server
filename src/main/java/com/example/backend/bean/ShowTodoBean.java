package com.example.backend.bean;

import com.example.backend.bean.small.ChangeDAOBean;
import com.example.backend.bean.small.GetCategoryDAOsBean;
import com.example.backend.bean.small.GetTodoDAOsBean;
import com.example.backend.bean.small.NewObjectDAOBean;
import com.example.backend.model.dto.ResponseSearchTodoByUserAndDate;
import com.example.backend.model.dto.ResponseTodoByCategory;
import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowTodoBean {
    private final GetTodoDAOsBean getTodoDAOsBean;
    private final NewObjectDAOBean newObjectDAOBean;
    private final GetCategoryDAOsBean getCategoryDAOsBean;
    private final ChangeDAOBean changeDAOBean;

    public List<TodoEntity> exec(Long userId) {
        return getTodoDAOsBean.exec(userId);
    }

    public ResponseSearchTodoByUserAndDate exec(Long userId, LocalDate date) {
        List<ResponseTodoByCategory> responseTodoByCategoryList = changeDAOBean.execCategory(getCategoryDAOsBean.exec(userId));

        for(ResponseTodoByCategory responseTodoByCategory : responseTodoByCategoryList) {
            responseTodoByCategory.getTodoList()
                    .addAll(changeDAOBean.execTodo(getTodoDAOsBean.exec(userId, responseTodoByCategory.getCategoryId(), date)));
        }

        return newObjectDAOBean.exec(userId, date, responseTodoByCategoryList);
    }
}