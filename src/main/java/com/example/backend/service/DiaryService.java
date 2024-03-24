package com.example.backend.service;

import com.example.backend.bean.SaveDiaryBean;
import com.example.backend.model.dto.RequestModifyTodoInput;
import com.example.backend.model.dto.RequestWriteDiaryInput;
import com.example.backend.model.entity.DiaryEntity;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final SaveDiaryBean saveDiaryBean;
    public DiaryEntity saveDiaryEntity(RequestWriteDiaryInput requestWriteDiaryInput) {
        return saveDiaryBean.exec(requestWriteDiaryInput);
    }

    public TodoEntity modifyTodoEntity(RequestModifyTodoInput requestModifyTodoInput) {
        return modifyTodoBean.exec(requestModifyTodoInput);
    }

    public Long deleteTodoEntity(Long todoId) {
        return deleteTodoBean.exec(todoId);
    }

    public List<TodoEntity> getTodoEntityByUser(Long userId) {
        return showTodoBean.exec(userId);
    }
}
