package com.example.backend.bean;

import com.example.backend.bean.small.GetUserDAOBean;
import com.example.backend.model.dto.RequestUserInput;
import com.example.backend.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUserBean {
    private final GetUserDAOBean getUserDAOBean;

    public UserEntity exec(Object object) {
        return getUserDAOBean.exec((RequestUserInput) object);
    }
}