package com.example.backend.model.entity;

import com.example.backend.model.dto.RequestUserSignup;
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
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String username;
    private String password;
    private String resolution;

    @Builder
    public UserEntity(RequestUserSignup requestUserSignup) {
        this.email = requestUserSignup.getEmail();
        this.username = requestUserSignup.getUsername();
        this.password = requestUserSignup.getPassword();
    }

    public UserEntity(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}