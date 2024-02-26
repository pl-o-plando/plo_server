package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestUserSignup;
import com.example.backend.model.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckDAOBean {
    private final UserRepository userRepository;

    // 회원가입시 비밀번호, 비밀번호 확인이 올바른지 확인
    public boolean exec(RequestUserSignup requestUserSignup) {
        return requestUserSignup.getPassword().equals(requestUserSignup.getRe_password());
    }

    // 존재하는 유저인지 확인
    public boolean exec(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return userEntity == null;
    }
}
