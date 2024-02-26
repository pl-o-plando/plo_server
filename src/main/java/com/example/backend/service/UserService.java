package com.example.backend.service;

import com.example.backend.bean.LoginUserBean;
import com.example.backend.bean.SignupUserBean;
import com.example.backend.model.dto.RequestUserInput;
import com.example.backend.model.dto.RequestUserSignup;
import com.example.backend.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final LoginUserBean getUserBean;
    private final SignupUserBean signupUserBean;

    // 회원가입
    public UserEntity signupUser(RequestUserSignup requestUserSignup) {
        return signupUserBean.exec(requestUserSignup);
    }

    // 로그인
    public UserEntity loginUser(RequestUserInput requestUserInput) {
        return getUserBean.exec(requestUserInput);
    }
}