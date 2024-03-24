package com.example.backend.service;

import com.example.backend.bean.DeleteDiaryBean;
import com.example.backend.bean.ModifyDiaryBean;
import com.example.backend.bean.SaveDiaryBean;
import com.example.backend.bean.ShowDiaryBean;
import com.example.backend.model.dto.RequestModifyDiaryInput;
import com.example.backend.model.dto.RequestWriteDiaryInput;
import com.example.backend.model.entity.DiaryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final SaveDiaryBean saveDiaryBean;
    private final DeleteDiaryBean deleteDiaryBean;
    private final ModifyDiaryBean modifyDiaryBean;
    private final ShowDiaryBean showDiaryBean;

    public DiaryEntity saveDiaryEntity(RequestWriteDiaryInput requestWriteDiaryInput) {
        return saveDiaryBean.exec(requestWriteDiaryInput);
    }

    public DiaryEntity modifyDiaryEntity(RequestModifyDiaryInput requestModifyDiaryInput) {
        return modifyDiaryBean.exec(requestModifyDiaryInput);
    }

    public Long deleteDiaryEntity(Long diaryId) {
        return deleteDiaryBean.exec(diaryId);
    }

    public DiaryEntity getTodoEntityByUserAndDate(Long userId, LocalDate date) {
        return showDiaryBean.exec(userId, date);
    }
}
