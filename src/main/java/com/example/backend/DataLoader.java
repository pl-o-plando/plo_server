package com.example.backend;

import com.example.backend.model.entity.TodoEntity;
import com.example.backend.model.entity.UserEntity;
import com.example.backend.repository.TodoRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        UserEntity userEntity = new UserEntity("string", "string", "string");
        userRepository.save(userEntity);

        TodoEntity todoEntity = new TodoEntity("string", "string", "string", "2024-02-24");
        todoRepository.save(todoEntity);
    }
}
