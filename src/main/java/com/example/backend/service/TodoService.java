package com.example.backend.service;

import com.example.backend.bean.SaveTodoBean;
import com.example.backend.bean.small.CheckDAOBean;
import com.example.backend.model.dto.RequestTodoInput;
import com.example.backend.model.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final SaveTodoBean saveTodoBean;

    public TodoEntity saveTodoEntity(String username, RequestTodoInput requestTodoInput) {
        return saveTodoBean.exec(username, requestTodoInput);
    }

//    public TodoEntity createTodo(String username, WriteTodoDTO writeTodoDTO) throws Exception {
//        if(!userRepository.findByUsername(username).isPresent()) {
//            new Exception("존재하지 않는 유저입니다.");
//        }
//
//        TodoEntity createTodoEntity = TodoEntity.builder()
//                                .username(username)
//                                .createTodoDTO(writeTodoDTO)
//                                .build();
//
//        todoRepository.save(createTodoEntity);
//
//        return createTodoEntity;
//    }
//
//    public TodoEntity updateTodo(String username, Long todoId, WriteTodoDTO writeTodoDTO) throws Exception {
//        if(!userRepository.findByUsername(username).isPresent()) {
//            new Exception("존재하지 않는 유저입니다.");
//        }
//
//        if(!todoRepository.findById(todoId).isPresent()) {
//            new Exception("존재하지 않는 파일입니다.");
//        }
//
//        TodoEntity updateTodoEntity = todoRepository.getById(todoId);
//        updateTodoEntity.updateTodo(writeTodoDTO);
//
//        todoRepository.save(updateTodoEntity);
//
//        return updateTodoEntity;
//    }
}