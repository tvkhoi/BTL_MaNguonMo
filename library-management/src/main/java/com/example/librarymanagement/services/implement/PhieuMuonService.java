package com.example.librarymanagement.services.implement;

import com.example.librarymanagement.models.PhieuMuon;
import com.example.librarymanagement.reponsitories.IPhieuMuonRepository;
import com.example.librarymanagement.services.IPhieuMuonService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhieuMuonService  implements IPhieuMuonService {
    IPhieuMuonRepository phieuMuonRepository;
    @Override
    public List<PhieuMuon> findAll() {
        return phieuMuonRepository.findAll();
    }

    @Override
    public PhieuMuon save(PhieuMuon phieuMuon) {
        return phieuMuonRepository.save(phieuMuon);
    }
}
