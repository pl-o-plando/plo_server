package com.example.backend.controller;

import com.example.backend.model.dto.RequestTodoInput;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @Operation(summary = "투두 작성", description = "투두 작성 성공 여부를 반환합니다.")
    @PostMapping("/{username}/todo/write")
    public ResponseEntity<Map<String, Object>> writeTodo(@PathVariable("username") String username, @RequestBody RequestTodoInput requestTodoInput) {
        // 회원가입 정보 받기
        TodoEntity todoEntity = todoService.saveTodoEntity(username, requestTodoInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (todoEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 User 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (todoEntity != null) ? "Todo Write Success" : "Todo Write Fail");
        requestMap.put("todo", todoEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 할 일 삭제
    @Operation(summary = "투두 삭제", description = "투두 삭제 성공 여부를 반환합니다.")
    @DeleteMapping("/{username}/todo/delete/{todo_id}")
    public ResponseEntity<Map<String, Object>> deleteTodo(@PathVariable("username") String username, @PathVariable("todo_id") Long todoId) {
        Long id = todoService.deleteTodoEntity(username, todoId);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
