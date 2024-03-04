package com.example.backend.bean.small;

import com.example.backend.model.entity.RoutineEntity;
import com.example.backend.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetRoutineDAOBean {
    private final RoutineRepository routineRepository;

    public RoutineEntity exec(Long routineId) {
        return routineRepository.findById(routineId).get();
    }
}
