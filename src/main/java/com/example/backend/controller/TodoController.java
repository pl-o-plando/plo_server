package com.example.backend.controller;

import com.example.backend.model.dto.RequestModifyTodoInput;
import com.example.backend.model.dto.RequestWriteTodoInput;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @Operation(summary = "투두 작성", description = "투두 작성 성공 여부를 반환합니다.")
    @PostMapping("/todo/write")
    public ResponseEntity<Map<String, Object>> writeTodo(@RequestBody RequestWriteTodoInput requestWriteTodoInput) {
        // 할일 저장하기
        TodoEntity todoEntity = todoService.saveTodoEntity(requestWriteTodoInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (todoEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 할일 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (todoEntity != null) ? "Todo Write Success" : "Todo Write Fail");
        requestMap.put("todo", todoEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "투두 수정", description = "투두 수정 성공 여부를 반환합니다.")
    @PostMapping("/todo/modify")
    public ResponseEntity<Map<String, Object>> modifyTodo(@RequestBody RequestModifyTodoInput requestModifyTodoInput) {
        // 회원가입 정보 받기
        TodoEntity todoEntity = todoService.modifyTodoEntity(requestModifyTodoInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (todoEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 할일 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (todoEntity != null) ? "Todo Modify Success" : "Todo Modify Fail");
        requestMap.put("todo", todoEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "투두 삭제", description = "투두 삭제 성공 여부를 반환합니다.")
    @DeleteMapping("/todo/delete")
    public ResponseEntity<Map<String, Object>> deleteTodo(@RequestParam("username") String username, @RequestParam("todo_id") Long todoId) {
        Long id = todoService.deleteTodoEntity(username, todoId);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "유저별 투두 조회", description = "조회된 투두 내역을 반환합니다.")
    @GetMapping("/todo/list/test")
    public List<TodoEntity> searchByUserTodo(@RequestParam("username") String username) {
        return todoService.getTodoEntityByUser(username);
    }

    @Operation(summary = "특정 유저의 날짜별 투두 조회", description = "조회된 투두 내역을 반환합니다.")
    @GetMapping("/todo/list")
    public List<TodoEntity> searchByDateTodo(@RequestParam("username") String username,
                                             @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return todoService.getTodoEntityByDate(username, date);
    }

    @Operation(summary = "투두 상태 변경", description = "투두 상태 변경 성공 여부를 반환합니다.")
    @PostMapping("/todo/state")
    public ResponseEntity<Map<String, Object>> changeStateTodo(@RequestParam("username") String username,
                                                               @RequestParam("todo_id") Long todoId,
                                                               @RequestParam("isCompleted") int isCompleted) {
        TodoEntity todoEntity = todoService.changeStateTodoEntity(username, todoId, isCompleted);

        // HTTP 상태 반환
        HttpStatus httpStatus = (todoEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 할일 데이터를 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (todoEntity != null) ? "Change State Success" : "Change State Fail");
        requestMap.put("todo", todoEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
