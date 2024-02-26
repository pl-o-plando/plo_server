package com.example.backend.domain.todos.service;

import com.example.backend.domain.todos.dto.WriteTodoDTO;
import com.example.backend.domain.todos.entity.Todo;
import com.example.backend.domain.todos.repository.TodoRepository;
import com.example.backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public Todo createTodo(String username, WriteTodoDTO writeTodoDTO) throws Exception {
        if(!userRepository.findByUsername(username).isPresent()) {
            new Exception("존재하지 않는 유저입니다.");
        }

        Todo createTodo = Todo.builder()
                                .username(username)
                                .createTodoDTO(writeTodoDTO)
                                .build();

        todoRepository.save(createTodo);

        return createTodo;
    }

    public Todo updateTodo(String username, Long todoId, WriteTodoDTO writeTodoDTO) throws Exception {
        if(!userRepository.findByUsername(username).isPresent()) {
            new Exception("존재하지 않는 유저입니다.");
        }

        if(!todoRepository.findById(todoId).isPresent()) {
            new Exception("존재하지 않는 파일입니다.");
        }

        Todo updateTodo = todoRepository.getById(todoId);
        updateTodo.updateTodo(writeTodoDTO);

        todoRepository.save(updateTodo);

        return updateTodo;
    }
}