package com.example.backend.controller;

import com.example.backend.model.entity.CategoryEntity;
import com.example.backend.service.CategoryService;
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
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(summary = "카테고리 추가", description = "카테고리 추가 성공 여부를 반환합니다.")
    @PostMapping("/category/create")
    public ResponseEntity<Map<String, Object>> createCategory(@RequestParam("username") String username, @RequestParam("category") String category) {
        // 카테고리 저장하기
        CategoryEntity categoryEntity = categoryService.saveCategoryEntity(username, category);

        // HTTP 상태 반환
        HttpStatus httpStatus = (categoryEntity != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 카테고리 데이터를 JSON 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (categoryEntity != null) ? "Category Create Success" : "Category Create Fail");
        requestMap.put("category", categoryEntity);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "카테고리 삭제", description = "카테고리 삭제 성공 여부를 반환합니다.")
    @DeleteMapping("/category/delete")
    public ResponseEntity<Map<String, Object>> deleteCategory(@RequestParam("category_id") Long categoryId) {
        Long id = categoryService.deleteCategoryEntity(categoryId);

        // HTTP 상태 반환
        HttpStatus httpStatus = (id != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (id != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("id", id);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    @Operation(summary = "유저별 카테고리 조회", description = "조회된 카테고리 내역을 반환합니다.")
    @GetMapping("/category/list")
    public List<CategoryEntity> searchByUserTodo(@RequestParam("username") String username) {
        return categoryService.getCategoryEntityByUsername(username);
    }
}
