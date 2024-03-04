package com.example.backend.bean;

import com.example.backend.bean.small.NewObjectDAOBean;
import com.example.backend.bean.small.SaveDAOBean;
import com.example.backend.model.dto.RequestCreateRoutineInput;
import com.example.backend.model.entity.RoutineEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveRoutineBean {
    private final SaveDAOBean saveDAOBean;
    private final NewObjectDAOBean newObjectDAOBean;

    public RoutineEntity exec(RequestCreateRoutineInput requestCreateRoutineInput) {

        RoutineEntity routineEntity = newObjectDAOBean.exec(requestCreateRoutineInput);
        saveDAOBean.exec(routineEntity);

        return routineEntity;
    }
}
