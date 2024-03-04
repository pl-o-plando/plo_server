package com.example.backend.model.entity;

import com.example.backend.model.dto.RequestCreateRoutineInput;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RoutineEntity {
    @Id
    @GeneratedValue
    @Column(name = "routine_id")
    private Long id;

    private String routine;

    private Long categoryId;

    @Builder
    public RoutineEntity(RequestCreateRoutineInput requestCreateRoutineInput) {
        this.categoryId = requestCreateRoutineInput.getCategoryId();
        this.routine = requestCreateRoutineInput.getRoutine();
    }
}
