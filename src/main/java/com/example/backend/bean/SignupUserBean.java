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
        if(!checkDAOBean.exec(requestUserSignup.getEmail(), requestUserSignup.getUsername())) return null;

        UserEntity createUser = newObjectDAOBean.exec(requestUserSignup);
        saveDAOBean.exec(createUser);

        CategoryEntity categoryEntity = newObjectDAOBean.exec(createUser.getId(), "카테고리1");
        saveDAOBean.exec(categoryEntity);

        return createUser;
    }
}