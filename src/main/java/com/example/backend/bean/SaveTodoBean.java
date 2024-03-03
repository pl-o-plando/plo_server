package com.example.backend.bean;

import com.example.backend.bean.small.CheckDAOBean;
import com.example.backend.bean.small.NewObjectDAOBean;
import com.example.backend.bean.small.SaveDAOBean;
import com.example.backend.model.dto.RequestWriteTodoInput;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveTodoBean {
    private final CheckDAOBean checkDAOBean;
    private final NewObjectDAOBean newObjectDAOBean;
    private final SaveDAOBean saveDAOBean;

    public TodoEntity exec(RequestWriteTodoInput requestWriteTodoInput) {
        if(checkDAOBean.exec(requestWriteTodoInput.getUserId())) return null;

        TodoEntity todoEntity = newObjectDAOBean.exec(requestWriteTodoInput);

        saveDAOBean.exec(todoEntity);

        return todoEntity;
    }
}