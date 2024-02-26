package com.example.backend.domain.todos.service;

import com.example.backend.domain.todos.dto.CreateTodoDTO;
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

    public Todo createTodo(String username, CreateTodoDTO createTodoDTO) throws Exception {
        if(!userRepository.findByUsername(username).isPresent()) {
            new Exception("존재하지 않는 유저입니다.");
        }

        Todo createTodo = Todo.builder()
                                .username(username)
                                .createTodoDTO(createTodoDTO)
                                .build();

        todoRepository.save(createTodo);

        return createTodo;
    }
}