package com.example.backend.controller;

import com.example.backend.dto.WriteTodoDTO;
import com.example.backend.entity.Todo;
import com.example.backend.service.TodoService;
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
    public ResponseEntity<?> createTodo(@PathVariable("username") String username, @RequestBody WriteTodoDTO writeTodoDTO) {
        try {
            Todo createTodo = todoService.createTodo(username, writeTodoDTO);

            // 투두 작성 성공 시 사용자 정보 반환
            return ResponseEntity.ok(createTodo);
        } catch (Exception e) {

            // 투두 작성 실패 시 400 Bad Request 반환
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @Operation(summary = "투두 수정", description = "투두 수정 성공 여부를 반환합니다.")
    @PostMapping("/{username}/todo/update/{todo_id}")
    public ResponseEntity<?> updateTodo(@PathVariable("username") String username,
                                        @PathVariable("todo_id") long todoId,
                                        @RequestBody WriteTodoDTO writeTodoDTO) {
        try {
            Todo updateTodo = todoService.updateTodo(username, todoId, writeTodoDTO);

            // 투두 작성 성공 시 사용자 정보 반환
            return ResponseEntity.ok(updateTodo);
        } catch (Exception e) {

            // 투두 작성 실패 시 400 Bad Request 반환
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
