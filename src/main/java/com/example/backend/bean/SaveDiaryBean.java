package com.example.backend.bean;

import com.example.backend.bean.small.CheckDAOBean;
import com.example.backend.bean.small.NewObjectDAOBean;
import com.example.backend.bean.small.SaveDAOBean;
import com.example.backend.model.dto.RequestWriteDiaryInput;
import com.example.backend.model.entity.DiaryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveDiaryBean {
    private final CheckDAOBean checkDAOBean;
    private final NewObjectDAOBean newObjectDAOBean;
    private final SaveDAOBean saveDAOBean;

    public DiaryEntity exec(RequestWriteDiaryInput requestWriteDiaryInput) {
        if(checkDAOBean.exec(requestWriteDiaryInput.getUserId())) return null;

        DiaryEntity diaryEntity = newObjectDAOBean.exec(requestWriteDiaryInput);

        saveDAOBean.exec(diaryEntity);

        return diaryEntity;
    }
}
