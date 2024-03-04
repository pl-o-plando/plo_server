package com.example.backend.bean.small;

import com.example.backend.model.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckDAOBean {
    private final UserRepository userRepository;

    // 이메일이 사용 중인지 확인
    public boolean exec(String email) {
        UserEntity userEntity1 = userRepository.findByEmail(email);

        return userEntity1 == null;
    }

    // 존재하는 유저 아이디인지 확인
    public boolean exec(Long userId) {
        UserEntity userEntity = userRepository.getById(userId);

        return userEntity == null;
    }
}
