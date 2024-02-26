package com.example.backend.service;

import com.example.backend.model.dto.WriteTodoDTO;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.repository.TodoRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

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