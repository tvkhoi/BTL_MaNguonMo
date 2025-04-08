package com.example.librarymanagement.controllers;

import com.example.librarymanagement.dto.SachDTO;
import com.example.librarymanagement.models.Sach;
import com.example.librarymanagement.services.ISachService;
import com.example.librarymanagement.dto.ApiResponse;
import com.example.librarymanagement.services.implement.SachService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/sach")
public class SachController {
    SachService sachService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Sach>>> getSach() {
        List<Sach> list = sachService.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(ApiResponse.<List<Sach>>builder()
                            .message("Không có sách nào.")
                            .code(404)
                            .build());
        }

        return ResponseEntity.ok(
                ApiResponse.<List<Sach>>builder()
                        .data(list)
                        .code(200)
                        .message("Lấy ra thành công")
                        .build()
        );
    }



    @PostMapping
    public ResponseEntity<ApiResponse<Sach>> addSach(@Valid @RequestBody SachDTO sachDTO) {
        Sach savedSach = sachService.saveDTO(sachDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<Sach>builder().code(201).data(savedSach).message("Thêm thành công").build());
    }






}
