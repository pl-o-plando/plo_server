package com.example.backend.bean.small;

import com.example.backend.model.entity.RoutineEntity;
import com.example.backend.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetRoutineDAOsBean {
    private final RoutineRepository routineRepository;

    public List<RoutineEntity> exec(Long categoryId) {
        return new ArrayList<>(routineRepository.findByCategoryId(categoryId));
    }
}
