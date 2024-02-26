package com.example.backend.controller;

import com.example.backend.model.dto.RequestTodoInput;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @Operation(summary = "투두 작성", description = "투두 작성 성공 여부를 반환합니다.")
    @PostMapping("/{username}/todo/write")
    public ResponseEntity<Map<String, Object>> write(@PathVariable("username") String username, @RequestBody RequestTodoInput requestTodoInput) {
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
//    public ResponseEntity<?> createTodo(@PathVariable("username") String username, @RequestBody WriteTodoDTO writeTodoDTO) {
//        try {
//            TodoEntity createTodoEntity = todoService.createTodo(username, writeTodoDTO);
//
//            // 투두 작성 성공 시 사용자 정보 반환
//            return ResponseEntity.ok(createTodoEntity);
//        } catch (Exception e) {
//
//            // 투두 작성 실패 시 400 Bad Request 반환
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//        }
//    }
//
//    @Operation(summary = "투두 수정", description = "투두 수정 성공 여부를 반환합니다.")
//    @PostMapping("/{username}/todo/update/{todo_id}")
//    public ResponseEntity<?> updateTodo(@PathVariable("username") String username,
//                                        @PathVariable("todo_id") long todoId,
//                                        @RequestBody WriteTodoDTO writeTodoDTO) {
//        try {
//            TodoEntity updateTodoEntity = todoService.updateTodo(username, todoId, writeTodoDTO);
//
//            // 투두 작성 성공 시 사용자 정보 반환
//            return ResponseEntity.ok(updateTodoEntity);
//        } catch (Exception e) {
//
//            // 투두 작성 실패 시 400 Bad Request 반환
//            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//        }
//    }
}
