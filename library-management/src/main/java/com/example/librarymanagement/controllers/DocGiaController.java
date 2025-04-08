package com.example.librarymanagement.controllers;

import com.example.librarymanagement.dto.ApiResponse;
import com.example.librarymanagement.dto.DocGiaDTO;
import com.example.librarymanagement.models.DocGia;
import com.example.librarymanagement.models.Sach;
import com.example.librarymanagement.services.implement.DocGiaService;
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
@RequestMapping("/docgia")
public class DocGiaController {
    DocGiaService docGiaService;

    @GetMapping("/{maDocGia}")
    public ResponseEntity<DocGia> getDocGia(@PathVariable Integer maDocGia) {

        return docGiaService.findDocGiaByMaDocGia(maDocGia).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<ApiResponse<DocGia>> updateDocGia(@Valid @RequestBody DocGiaDTO docGia) {
        DocGia updatedDocGia = docGiaService.updateDocgiaDTO(docGia);
        if (updatedDocGia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.<DocGia>builder()
                            .code(404)
                            .message("Không tìm thấy độc giả với mã: " + docGia.getMaDocGia())
                            .build());
        }
        return ResponseEntity.ok(
                ApiResponse.<DocGia>builder()
                        .data(updatedDocGia)
                        .code(200)
                        .message("Cập nhật thành công độc giả có mã: " + docGia.getMaDocGia())
                        .build()
        );
    }
}

