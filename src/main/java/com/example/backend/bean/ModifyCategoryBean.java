package com.example.backend.bean;

import com.example.backend.bean.small.*;
import com.example.backend.model.dto.RequestModifyCategoryInput;
import com.example.backend.model.dto.RequestModifyTodoInput;
import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModifyCategoryBean {
    private final CheckDAOBean checkDAOBean;
    private final GetCategoryDAOBean getCategoryDAOBean;
    private final ModifyObjectDAOBean modifyObjectDAOBean;
    private final SaveDAOBean saveDAOBean;

    public CategoryEntity exec(RequestModifyCategoryInput requestModifyCategoryInput) {
        CategoryEntity categoryEntity = getCategoryDAOBean.exec(requestModifyCategoryInput.getCategoryId());

        // 작성된 카테고리인지 확인
        if(categoryEntity == null) return null;

        // 값을 수정한 뒤 저장
        CategoryEntity modifyCategoryEntity = modifyObjectDAOBean.exec(categoryEntity, requestModifyCategoryInput);
        saveDAOBean.exec(modifyCategoryEntity);

        // 수정된 객체를 반환
        return modifyCategoryEntity;
    }
}
