package com.example.librarymanagement.services;

import com.example.librarymanagement.models.ChiTietPhieuMuon;

import java.util.List;
import java.util.Optional;

public interface IChiTietPhieuMuonService {
    List<ChiTietPhieuMuon> findAll();
    ChiTietPhieuMuon deleteById(Integer maChiTietPhieuMuon);
    Optional<ChiTietPhieuMuon> findById(Integer maChiTietPhieuMuon); // Thêm phương thức findById
}
