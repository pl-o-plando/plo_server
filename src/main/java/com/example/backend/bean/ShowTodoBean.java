package com.example.backend.bean;

import com.example.backend.bean.small.GetTodoDAOsBean;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowTodoBean {
    private final GetTodoDAOsBean getTodoDAOsBean;

    public List<TodoEntity> exec(String username) {
        return getTodoDAOsBean.exec(username);
    }
}