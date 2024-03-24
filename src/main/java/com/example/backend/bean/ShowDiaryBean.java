package com.example.backend.bean;

import com.example.backend.bean.small.GetDiaryDAOBean;
import com.example.backend.model.entity.DiaryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ShowDiaryBean {
    private final GetDiaryDAOBean getDiaryDAOBean;

    public DiaryEntity exec(Long userId, LocalDate date) {
        return getDiaryDAOBean.exec(userId, date);
    }
}
