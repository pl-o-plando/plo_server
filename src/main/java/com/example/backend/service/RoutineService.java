package com.example.backend.service;

import com.example.backend.bean.DeleteRoutineBean;
import com.example.backend.bean.ModifyRoutineBean;
import com.example.backend.bean.SaveRoutineBean;
import com.example.backend.bean.ShowRoutineBean;
import com.example.backend.model.dto.RequestCreateRoutineInput;
import com.example.backend.model.dto.RequestModifyCategoryInput;
import com.example.backend.model.dto.RequestModifyRoutineInput;
import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.RoutineEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutineService {
    private final SaveRoutineBean saveRoutineBean;
    private final DeleteRoutineBean deleteRoutineBean;
    private final ShowRoutineBean showRoutineBean;
    private final ModifyRoutineBean modifyRoutineBean;

    public RoutineEntity saveRoutineEntity(RequestCreateRoutineInput requestCreateRoutineInput) {
        return saveRoutineBean.exec(requestCreateRoutineInput);
    }

    public Long deleteRoutineEntity(Long routineId) {
        return deleteRoutineBean.exec(routineId);
    }

    public List<RoutineEntity> getRoutineEntityByCategoryId(Long categoryId) {
        return showRoutineBean.exec(categoryId);
    }

    public RoutineEntity modifyRoutineEntity(RequestModifyRoutineInput requestModifyRoutineInput) {
        return modifyRoutineBean.exec(requestModifyRoutineInput);
    }
}
