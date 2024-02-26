package com.example.backend.bean.small;

import com.example.backend.model.dto.RequestUserSignup;
import org.springframework.stereotype.Component;

@Component
public class CheckDAOBean {
    // 회원가입시 비밀번호, 비밀번호 확인이 올바른지 확인
    public boolean exec(RequestUserSignup requestUserSignup) {
        return requestUserSignup.getPassword().equals(requestUserSignup.getRe_password());
    }
}
