package com.example.backend.bean;

import com.example.backend.bean.small.GetDiaryDAOBean;
import com.example.backend.bean.small.ModifyObjectDAOBean;
import com.example.backend.bean.small.SaveDAOBean;
import com.example.backend.model.dto.RequestModifyDiaryInput;
import com.example.backend.model.entity.DiaryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModifyDiaryBean {
    private final GetDiaryDAOBean getDiaryDAOBean;
    private final ModifyObjectDAOBean modifyObjectDAOBean;
    private final SaveDAOBean saveDAOBean;

    public DiaryEntity exec(RequestModifyDiaryInput requestModifyDiaryInput) {
        DiaryEntity diaryEntity = getDiaryDAOBean.exec(requestModifyDiaryInput.getDiaryId());

        // 작성된 카테고리인지 확인
        if(diaryEntity == null) return null;

        // 값을 수정한 뒤 저장
        DiaryEntity modifyDiaryEntity = modifyObjectDAOBean.exec(diaryEntity, requestModifyDiaryInput);
        saveDAOBean.exec(modifyDiaryEntity);

        // 수정된 객체를 반환
        return modifyDiaryEntity;
    }
}
