package com.example.backend.bean;

import com.example.backend.bean.small.GetRoutineDAOsBean;
import com.example.backend.model.entity.RoutineEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowRoutineBean {
    private final GetRoutineDAOsBean getRoutineDAOsBean;

    public List<RoutineEntity> exec(Long categoryId) {
        return getRoutineDAOsBean.exec(categoryId);
    }
}