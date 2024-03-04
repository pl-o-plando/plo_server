package com.example.backend.bean;

import com.example.backend.bean.small.*;
import com.example.backend.model.dto.RequestModifyUserInput;
import com.example.backend.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModifyUserBean {
    private final CheckDAOBean checkDAOBean;
    private final GetUserDAOBean getUserDAOBean;
    private final ModifyObjectDAOBean modifyObjectDAOBean;
    private final SaveDAOBean saveDAOBean;

    public UserEntity exec(RequestModifyUserInput requestModifyUserInput) {
        // 존재하는 유저인지 확인
        if(checkDAOBean.exec(requestModifyUserInput.getUserId())) return null;

        UserEntity userEntity = getUserDAOBean.exec(requestModifyUserInput.getUserId());

        // 작성된 할일인지 확인
        if(userEntity == null) return null;

        // 값을 수정한 뒤 저장
        UserEntity modifyuserEntity = modifyObjectDAOBean.exec(userEntity, requestModifyUserInput);
        saveDAOBean.exec(modifyuserEntity);

        // 수정된 객체를 반환
        return modifyuserEntity;
    }
}
