package com.example.backend.bean;

import com.example.backend.bean.small.*;
import com.example.backend.model.dto.RequestChangeStateTodoInput;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChangeStateTodoBean {
    private final GetTodoDAOBean getTodoDAOBean;
    private final ModifyObjectDAOBean modifyObjectDAOBean;
    private final SaveDAOBean saveDAOBean;

    public TodoEntity exec(RequestChangeStateTodoInput requestChangeStateTodoInput) {

        // 할일 객체 불러오기
        TodoEntity todoEntity = getTodoDAOBean.exec(requestChangeStateTodoInput.getTodoId());

        // 객체가 존재하면서 객체의 유저와 요청받은 유저가 같은 사람인지 확인
        if(todoEntity != null) {
            // 만족한다면 객체의 값을 변경한 뒤 값을 저장
            TodoEntity updatetodoEntity = modifyObjectDAOBean.exec(todoEntity, requestChangeStateTodoInput.getIsCompleted());
            saveDAOBean.exec(updatetodoEntity);

            return updatetodoEntity;
        }
        return null;
    }
}
