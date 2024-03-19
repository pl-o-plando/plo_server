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
        userRepository.save(new UserEntity("string", "string", "string"));

        todoRepository.save(new TodoEntity("string1", Long.parseLong("1"), Long.parseLong("1"), "2024-02-24"));
        todoRepository.save(new TodoEntity("string2", Long.parseLong("1"), Long.parseLong("1"), "2024-02-24"));
    }
}
