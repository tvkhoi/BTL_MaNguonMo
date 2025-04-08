package com.example.librarymanagement.controllers;

import com.example.librarymanagement.dto.PhieuMuonDTO;
import com.example.librarymanagement.exception.ApiException;
import com.example.librarymanagement.exception.ErrorCode;
import com.example.librarymanagement.models.PhieuMuon;
import com.example.librarymanagement.dto.ApiResponse;
import com.example.librarymanagement.services.implement.PhieuMuonService;
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
@RequestMapping("/phieumuon")
public class PhieuMuonController {
    PhieuMuonService phieuMuonService;

    @GetMapping
    public ResponseEntity<List<PhieuMuon>> getPhieuMuon() {
        return ResponseEntity.ok(phieuMuonService.findAll());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PhieuMuon>> addPhieuMuon(@RequestBody PhieuMuon phieuMuon) {
        // Kiểm tra độc giả có tồn tại không
        if (phieuMuon.getDocGia() == null || phieuMuon.getDocGia().getMaDocGia() == null) {
            throw new ApiException(ErrorCode.INVALID_DATA);
        }

        PhieuMuon savedPhieuMuon = phieuMuonService.save(phieuMuon);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<PhieuMuon>builder().data(savedPhieuMuon).build());
    }

    // Trả sách
    @PutMapping("/traSach/{id}")
    public ResponseEntity<ApiResponse<PhieuMuon>> traSach(@PathVariable int id) {
        PhieuMuon phieuMuon = phieuMuonService.update(id);
        if(phieuMuon == null) {
            throw new ApiException(ErrorCode.INVALID_DATA);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<PhieuMuon>(200,"Trả sách thành công",phieuMuon));
    }

    // Mượn sách
    @PostMapping("/muonSach")
    public ResponseEntity<ApiResponse<PhieuMuon>> muonSach(@RequestBody PhieuMuonDTO phieuMuonDTO) {
        try {
            PhieuMuon phieuMuon = phieuMuonService.xacNhanMuonSach(phieuMuonDTO);
            return ResponseEntity.ok(
                    ApiResponse.<PhieuMuon>builder()
                            .code(200)
                            .message("Mượn sách thành công")
                            .data(phieuMuon)
                            .build()
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ApiResponse.<PhieuMuon>builder()
                            .code(400)
                            .message("Lỗi khi mượn sách: " + e.getMessage())
                            .data(null)
                            .build()
            );
        }
    }

}