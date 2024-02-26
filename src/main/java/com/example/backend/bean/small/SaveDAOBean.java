package com.example.backend.bean.small;

import com.example.backend.model.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveDAOBean {
    private final UserRepository userRepository;

    // 유저 저장
    public void exec(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}