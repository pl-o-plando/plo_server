package com.example.backend.service;

import com.example.backend.bean.DeleteDiaryBean;
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
    private final DeleteDiaryBean deleteDiaryBean;

    public DiaryEntity saveDiaryEntity(RequestWriteDiaryInput requestWriteDiaryInput) {
        return saveDiaryBean.exec(requestWriteDiaryInput);
    }

    public TodoEntity modifyTodoEntity(RequestModifyTodoInput requestModifyTodoInput) {
        return modifyTodoBean.exec(requestModifyTodoInput);
    }

    public Long deleteDiaryEntity(Long diaryId) {
        return deleteDiaryBean.exec(diaryId);
    }

    public List<TodoEntity> getTodoEntityByUser(Long userId) {
        return showTodoBean.exec(userId);
    }
}
