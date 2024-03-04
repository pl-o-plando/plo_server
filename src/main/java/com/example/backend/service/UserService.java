package com.example.backend.service;

import com.example.backend.bean.LoginUserBean;
import com.example.backend.bean.ModifyUserBean;
import com.example.backend.bean.SignupUserBean;
import com.example.backend.model.dto.RequestModifyUserInput;
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
    private final ModifyUserBean modifyUserBean;

    // 회원가입
    public UserEntity signupUser(RequestUserSignup requestUserSignup) {
        return signupUserBean.exec(requestUserSignup);
    }

    // 로그인
    public UserEntity loginUser(RequestUserInput requestUserInput) {
        return getUserBean.exec(requestUserInput);
    }

    // 유저 정보 수정
    public UserEntity modifyUserEntity(RequestModifyUserInput requestModifyUserInput) {
        return modifyUserBean.exec(requestModifyUserInput);
    }
}