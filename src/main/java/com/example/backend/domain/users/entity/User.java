package com.example.backend.domain.users.entity;

import com.example.backend.domain.BaseEntity;
import com.example.backend.domain.users.dto.UserSignUpDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String username;
    private String password;
    private String resolution;

    @Builder
    public User(UserSignUpDto userSignUpDto) {
        this.email = userSignUpDto.getEmail();
        this.username = userSignUpDto.getUsername();
        this.password = userSignUpDto.getPassword();
    }
}