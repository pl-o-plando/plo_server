package com.example.backend.bean;

import com.example.backend.bean.small.CheckDAOBean;
import com.example.backend.bean.small.GetTodoDAOBean;
import com.example.backend.bean.small.ModifyObjectDAOBean;
import com.example.backend.bean.small.SaveDAOBean;
import com.example.backend.model.dto.RequestModifyTodoInput;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModifyTodoBean {
    private final CheckDAOBean checkDAOBean;
    private final GetTodoDAOBean getTodoDAOBean;
    private final ModifyObjectDAOBean modifyObjectDAOBean;
    private final SaveDAOBean saveDAOBean;

    public TodoEntity exec(RequestModifyTodoInput requestModifyTodoInput) {
        // 존재하는 유저인지 확인
        if(checkDAOBean.exec(requestModifyTodoInput.getUserId())) return null;

        TodoEntity todoEntity = getTodoDAOBean.exec(requestModifyTodoInput.getTodoId());

        // 작성된 할일인지 확인
        if(todoEntity == null) return null;

        // 값을 수정한 뒤 저장
        TodoEntity modifytodoEntity = modifyObjectDAOBean.exec(todoEntity, requestModifyTodoInput);
        saveDAOBean.exec(modifytodoEntity);

        // 수정된 객체를 반환
        return modifytodoEntity;
    }
}
