package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestUserInput;
import com.example.backend.model.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserDAOBean {
    private final UserRepository userRepository;

    // 이메일과 비밀번호로 유저 찾기
    public UserEntity exec(RequestUserInput requestUserInput) {
        return userRepository.findByEmailAndPassword(requestUserInput.getEmail(), requestUserInput.getPassword());
    }

    // 유저 아이디로 유저 찾기
    public UserEntity exec(Long userId) {
        return userRepository.getById(userId);
    }
}