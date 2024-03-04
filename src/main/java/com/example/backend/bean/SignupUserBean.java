package com.example.backend.bean;

import com.example.backend.bean.small.CheckDAOBean;
import com.example.backend.bean.small.NewObjectDAOBean;
import com.example.backend.bean.small.SaveDAOBean;
import com.example.backend.model.dto.RequestUserSignup;
import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignupUserBean {
    private final NewObjectDAOBean newObjectDAOBean;
    private final SaveDAOBean saveDAOBean;
    private final CheckDAOBean checkDAOBean;

    public UserEntity exec(RequestUserSignup requestUserSignup) {
        if(!checkDAOBean.exec(requestUserSignup.getEmail())) return null;

        UserEntity createUser = newObjectDAOBean.exec(requestUserSignup);
        saveDAOBean.exec(createUser);

        // 유저 생성시 기본 카테고리 제공
        CategoryEntity categoryEntity = newObjectDAOBean.exec(createUser.getId(), "카테고리1");
        saveDAOBean.exec(categoryEntity);

        return createUser;
    }
}