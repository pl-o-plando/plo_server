package com.example.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
}
