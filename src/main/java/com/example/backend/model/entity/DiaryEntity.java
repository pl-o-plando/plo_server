package com.example.backend.model.entity;

import com.example.backend.model.dto.RequestWriteDiaryInput;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DiaryEntity {
    @Id
    @GeneratedValue
    @Column(name = "diary_id")
    private Long id;

    private String content;
    private LocalDate createdAt;

    private Long userId;

    private boolean isDeleted;

    @Builder
    public DiaryEntity(RequestWriteDiaryInput requestWriteDiaryInput) {
        this.content = requestWriteDiaryInput.getContent();
        this.createdAt = LocalDate.parse(requestWriteDiaryInput.getDate());
        this.userId = requestWriteDiaryInput.getUserId();
        this.isDeleted = false;
    }

    public DiaryEntity(String content, String date, Long userId) {
        this.content = content;
        this.createdAt = LocalDate.parse(date);
        this.userId = userId;
        this.isDeleted = false;
    }
}
