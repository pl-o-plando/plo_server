package com.example.backend.bean;

import com.example.backend.bean.small.DeleteDAOBean;
import com.example.backend.bean.small.GetTodoDAOBean;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteTodoBean {
    private final GetTodoDAOBean getTodoDAOBean;
    private final DeleteDAOBean deleteDAOBean;

    public Long exec(Long todoId) {
        // 할일 객체 불러오기
        TodoEntity todoEntity = getTodoDAOBean.exec(todoId);

        // 객체가 존재하면서 객체의 유저와 요청받은 유저가 같은 사람인지 확인
        if(todoEntity != null) {
            // 만족한다면 삭제 후 삭제된 아이디를 리턴
            deleteDAOBean.exec(todoEntity);

            return todoId;
        }
        return null;
    }
}
