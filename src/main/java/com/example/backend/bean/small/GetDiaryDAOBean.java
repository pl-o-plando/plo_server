package com.example.backend.bean.small;

import com.example.backend.model.entity.DiaryEntity;
import com.example.backend.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetDiaryDAOBean {
    private final DiaryRepository diaryRepository;

    public DiaryEntity exec(Long diaryId) {
        return diaryRepository.findById(diaryId).get();
    }
}
