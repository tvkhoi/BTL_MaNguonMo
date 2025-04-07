package com.example.librarymanagement.controllers;

import com.example.librarymanagement.models.ChiTietPhieuMuon;
import com.example.librarymanagement.services.IChiTietPhieuMuonService;
import com.example.librarymanagement.dto.ApiResponse;
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
@RequestMapping("/chitietphieumuon")
public class ChiTietPhieuMuonController {
    IChiTietPhieuMuonService chiTietPhieuMuonService;

    @GetMapping
    public ResponseEntity<List<ChiTietPhieuMuon>> getPhieuMuon() {
        return ResponseEntity.ok(chiTietPhieuMuonService.findAll());
    }
    // Lấy chi tiết phiếu mượn theo ID
    @GetMapping("/{maChiTietPhieuMuon}")
    public ResponseEntity<ChiTietPhieuMuon> getChiTietPhieuMuonById(@PathVariable Integer maChiTietPhieuMuon) {
        return chiTietPhieuMuonService.findById(maChiTietPhieuMuon)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Xóa chi tiết phiếu mượn
    @DeleteMapping("/{maChiTietPhieuMuon}")
    public ResponseEntity<ApiResponse<Void>> deleteChiTietPhieuMuon(@PathVariable Integer maChiTietPhieuMuon) {
        ChiTietPhieuMuon deleted = chiTietPhieuMuonService.deleteById(maChiTietPhieuMuon);
        if (deleted != null) {
            return ResponseEntity.ok(
                    ApiResponse.<Void>builder()
                            .message("Xóa chi tiết phiếu mượn thành công")
                            .build());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.<Void>builder()
                        .message("Không tìm thấy chi tiết phiếu mượn với ID: " + maChiTietPhieuMuon)
                        .build());
    }









}
