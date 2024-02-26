package com.example.backend.domain.todos.controller;

import com.example.backend.domain.ErrorResponse;
import com.example.backend.domain.todos.dto.CreateTodoDTO;
import com.example.backend.domain.todos.entity.Todo;
import com.example.backend.domain.todos.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @Operation(summary = "투두 작성", description = "투두 작성 성공 여부를 반환합니다.")
    @PostMapping("/{username}/todo/write")
    public ResponseEntity<?> signUp(@PathVariable("username") String username, @RequestBody CreateTodoDTO createTodoDTO) {
        try {
            Todo createTodo = todoService.createTodo(username, createTodoDTO);

            // 투두 작성 성공 시 사용자 정보 반환
            return ResponseEntity.ok(createTodo);
        } catch (Exception e) {

            // 투두 작성 실패 시 400 Bad Request 반환
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
