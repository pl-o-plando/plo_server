package com.example.backend.bean;

import com.example.backend.bean.small.CheckDAOBean;
import com.example.backend.bean.small.DeleteDAOBean;
import com.example.backend.bean.small.GetTodoDAOBean;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteTodoBean {
    private final CheckDAOBean checkDAOBean;
    private final GetTodoDAOBean getTodoDAOBean;
    private final DeleteDAOBean deleteDAOBean;

    public Long exec(String username, Long todoId) {
        // 존재하는 유저인지 확인
        if(checkDAOBean.exec(username)) return null;

        // 할일 객체 불러오기
        TodoEntity todoEntity = getTodoDAOBean.exec(todoId);

        // 객체가 존재하면서 객체의 유저와 요청받은 유저가 같은 사람인지 확인
        if(todoEntity != null && checkDAOBean.exec(username, todoEntity)) {
            // 만족한다면 삭제 후 삭제된 아이디를 리턴
            deleteDAOBean.exec(todoEntity);

            return todoId;
        }
        return null;
    }
}
