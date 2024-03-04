package com.example.backend.bean;

import com.example.backend.bean.small.DeleteDAOBean;
import com.example.backend.bean.small.GetRoutineDAOBean;
import com.example.backend.model.entity.RoutineEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteRoutineBean {
    private final GetRoutineDAOBean getRoutineDAOBean;
    private final DeleteDAOBean deleteDAOBean;

    public Long exec(Long routineId) {
        RoutineEntity routineEntity = getRoutineDAOBean.exec(routineId);

        deleteDAOBean.exec(routineEntity);

        return routineId;
    }
}
