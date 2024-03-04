package com.example.backend.bean;

import com.example.backend.bean.small.*;
import com.example.backend.model.dto.RequestModifyCategoryInput;
import com.example.backend.model.dto.RequestModifyRoutineInput;
import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.RoutineEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModifyRoutineBean {
    private final GetRoutineDAOBean getRoutineDAOBean;
    private final ModifyObjectDAOBean modifyObjectDAOBean;
    private final SaveDAOBean saveDAOBean;

    public RoutineEntity exec(RequestModifyRoutineInput requestModifyRoutineInput) {
        RoutineEntity routineEntity = getRoutineDAOBean.exec(requestModifyRoutineInput.getRoutineId());

        // 작성된 루틴인지 확인
        if(routineEntity == null) return null;

        // 값을 수정한 뒤 저장
        RoutineEntity modifyRoutineEntity = modifyObjectDAOBean.exec(routineEntity, requestModifyRoutineInput);
        saveDAOBean.exec(modifyRoutineEntity);

        // 수정된 객체를 반환
        return modifyRoutineEntity;
    }
}
