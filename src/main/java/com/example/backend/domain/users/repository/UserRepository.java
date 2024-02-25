package com.example.backend.domain.users.repository;

import com.example.backend.domain.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String Username);

    Optional<User> findByEmailAndPassword(String email, String password);
}