package com.example.backend.bean.small;

import com.example.backend.model.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckDAOBean {
    private final UserRepository userRepository;

    // 이메일과 닉네임 중 하나라도 사용 중인지 확인
    public boolean exec(String email, String username) {
        UserEntity userEntity1 = userRepository.findByEmail(email);
        UserEntity userEntity2 = userRepository.findByUsername(username);

        return userEntity1 == null && userEntity2 == null;
    }

    // 존재하는 유저 아이디인지 확인
    public boolean exec(Long userId) {
        UserEntity userEntity = userRepository.getById(userId);

        return userEntity == null;
    }
}
