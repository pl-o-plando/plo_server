package com.example.backend.service;

import com.example.backend.bean.DeleteRoutineBean;
import com.example.backend.bean.SaveRoutineBean;
import com.example.backend.model.dto.RequestCreateRoutineInput;
import com.example.backend.model.entity.RoutineEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoutineService {
    private final SaveRoutineBean saveRoutineBean;
    private final DeleteRoutineBean deleteRoutineBean;

    public RoutineEntity saveRoutineEntity(RequestCreateRoutineInput requestCreateRoutineInput) {
        return saveRoutineBean.exec(requestCreateRoutineInput);
    }

    public Long deleteRoutineEntity(Long routineId) {
        return deleteRoutineBean.exec(routineId);
    }
}
