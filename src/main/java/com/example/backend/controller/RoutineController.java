package com.example.backend.controller;

import com.example.backend.model.dto.RequestCreateRoutineInput;
import com.example.backend.model.entity.RoutineEntity;
import com.example.backend.service.RoutineService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RoutineController {
    private final RoutineService routineService;

    @Operation(summary = "루틴 추가", description = "루틴 추가 성공 여부를 반환합니다.")
    @PostMapping("/routine/create")
    public ResponseEntity<Map<String, Object>> createRoutine(@RequestBody RequestCreateRoutineInput requestCreateRoutineInput) {
        // 루틴 저장하기
        RoutineEntity routineEntity = routineService.saveRoutineEntity(requestCreateRoutineInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (routineEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 카테고리 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (routineEntity != null) ? "Routine Create Success" : "Routine Create Fail");
        requestMap.put("routine", routineEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "루틴 삭제", description = "루틴 삭제 성공 여부를 반환합니다.")
    @DeleteMapping("/routine/delete")
    public ResponseEntity<Map<String, Object>> deleteRoutine(@RequestParam("routine_id") Long routineId) {
        Long id = routineService.deleteRoutineEntity(routineId);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "카테고리별 루틴 조회", description = "조회된 루틴 내역을 반환합니다.")
    @GetMapping("/routine/list")
    public List<RoutineEntity> searchByCategoryRoutine(@RequestParam("category_id") Long categoryId) {
        return routineService.getRoutineEntityByCategoryId(categoryId);
    }
}
