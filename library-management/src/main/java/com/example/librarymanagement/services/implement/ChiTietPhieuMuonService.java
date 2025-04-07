package com.example.librarymanagement.services.implement;

import com.example.librarymanagement.models.ChiTietPhieuMuon;
import com.example.librarymanagement.reponsitories.IChiTietPhieuMuonRepository;
import com.example.librarymanagement.services.IChiTietPhieuMuonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChiTietPhieuMuonService implements IChiTietPhieuMuonService {
    private final IChiTietPhieuMuonRepository chiTietPhieuMuonRepository;

    @Override
    public List<ChiTietPhieuMuon> findAll() {
        return chiTietPhieuMuonRepository.findAll();
    }

    @Override
    public ChiTietPhieuMuon deleteById(Integer maChiTietPhieuMuon) {
        Optional<ChiTietPhieuMuon> chiTiet = chiTietPhieuMuonRepository.findById(maChiTietPhieuMuon);
        if (chiTiet.isPresent()) {
            chiTietPhieuMuonRepository.deleteById(maChiTietPhieuMuon);
            return chiTiet.get();
        }
        return null;
    }

    @Override
    public Optional<ChiTietPhieuMuon> findById(Integer maChiTietPhieuMuon) {
        return chiTietPhieuMuonRepository.findById(maChiTietPhieuMuon);
    }
}