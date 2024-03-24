package com.example.backend;

import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.model.entity.DiaryEntity;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.model.entity.UserEntity;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.DiaryRepository;
import com.example.backend.repository.TodoRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;

    @Override
    public void run(String... args) {
        userRepository.save(new UserEntity("string", "string", "string"));

        categoryRepository.save(new CategoryEntity(Long.parseLong("1"), "카테고리1"));

        todoRepository.save(new TodoEntity("string1", Long.parseLong("1"), Long.parseLong("1"), "2024-02-24"));
        todoRepository.save(new TodoEntity("string2", Long.parseLong("1"), Long.parseLong("1"), "2024-02-24"));

        diaryRepository.save(new DiaryEntity("Good", "String", "2024-02-24", Long.parseLong("1")));
    }
}
