package com.example.backend.controller;

import com.example.backend.model.dto.RequestModifyDiaryInput;
import com.example.backend.model.dto.RequestWriteDiaryInput;
import com.example.backend.model.entity.DiaryEntity;
import com.example.backend.service.DiaryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @Operation(summary = "일기 삭제", description = "일기 삭제 성공 여부를 반환합니다.")
    @DeleteMapping("/diary/delete")
    public ResponseEntity<Map<String, Object>> deleteDiary(@RequestParam("diary_id") Long diaryId) {
        Long id = diaryService.deleteDiaryEntity(diaryId);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "일기 수정", description = "일기 수정 성공 여부를 반환합니다.")
    @PatchMapping("/diary/modify")
    public ResponseEntity<Map<String, Object>> modifyDiary(@RequestBody RequestModifyDiaryInput requestModifyDiaryInput) {
        // 투두 정보 받기
        DiaryEntity diaryEntity = diaryService.modifyDiaryEntity(requestModifyDiaryInput);

        // HTTP 상태 반환
        HttpStatus httpStatus = (diaryEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 할일 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (diaryEntity != null) ? "diary Modify Success" : "diary Modify Fail");
        requestMap.put("diary", diaryEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "특정 유저의 특정 날짜 일기 조회", description = "조회된 일기 내역을 반환합니다.")
    @GetMapping("/diary/search")
    public DiaryEntity searchByDateDiary(@RequestParam("userId") Long userId,
                                         @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return diaryService.getTodoEntityByUserAndDate(userId, date);
    }
}
