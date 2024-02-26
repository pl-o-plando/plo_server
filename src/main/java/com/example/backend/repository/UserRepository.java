package com.example.backend.repository;

import com.example.backend.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String Username);

    UserEntity findByEmailAndPassword(String email, String password);
}