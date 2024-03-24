package com.example.backend.controller;

import com.example.backend.model.dto.RequestWriteDiaryInput;
import com.example.backend.model.dto.RequestWriteTodoInput;
import com.example.backend.model.entity.DiaryEntity;
import com.example.backend.model.entity.TodoEntity;
import com.example.backend.service.DiaryService;
import com.example.backend.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @Operation(summary = "일기 작성", description = "일기 작성 성공 여부를 반환합니다.")
    @PostMapping("/diary/write")
    public ResponseEntity<Map<String, Object>> writeDiary(@RequestBody RequestWriteDiaryInput requestWriteDiaryInput) {
        // 할일 저장하기
        DiaryEntity diaryEntity = diaryService.saveDiaryEntity(requestWriteDiaryInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (diaryEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 할일 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (diaryEntity != null) ? "Diary Write Success" : "Diary Write Fail");
        requestMap.put("diary", diaryEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
