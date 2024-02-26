package com.example.backend.domain.users.entity;

import com.example.backend.domain.BaseEntity;
import com.example.backend.domain.users.dto.UserSignUpDTO;
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
    public User(UserSignUpDTO userSignUpDTO) {
        this.email = userSignUpDTO.getEmail();
        this.username = userSignUpDTO.getUsername();
        this.password = userSignUpDTO.getPassword();
    }
}