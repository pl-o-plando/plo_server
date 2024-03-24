package com.example.backend.bean;

import com.example.backend.bean.small.DeleteDAOBean;
import com.example.backend.bean.small.GetDiaryDAOBean;
import com.example.backend.model.entity.DiaryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteDiaryBean {
    private final GetDiaryDAOBean getDiaryDAOBean;
    private final DeleteDAOBean deleteDAOBean;

    public Long exec(Long diaryId) {
        DiaryEntity diaryEntity = getDiaryDAOBean.exec(diaryId);

        deleteDAOBean.exec(diaryEntity);

        return diaryId;
    }
}
