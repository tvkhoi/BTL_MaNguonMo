package com.example.librarymanagement.services.implement;

import com.example.librarymanagement.models.ChiTietPhieuMuon;
import com.example.librarymanagement.models.PhieuMuon;
import com.example.librarymanagement.models.Sach;
import com.example.librarymanagement.reponsitories.IChiTietPhieuMuonRepository;
import com.example.librarymanagement.reponsitories.IPhieuMuonRepository;
import com.example.librarymanagement.reponsitories.ISachRepository;
import com.example.librarymanagement.services.IPhieuMuonService;
import com.example.librarymanagement.services.ISachService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhieuMuonService  implements IPhieuMuonService {
    IPhieuMuonRepository phieuMuonRepository;
    IChiTietPhieuMuonRepository chiTietPhieuMuonRepository;
    ISachRepository sachRepository;
    @Override
    public List<PhieuMuon> findAll() {
        return phieuMuonRepository.findAll();
    }

    @Override
    public PhieuMuon save(PhieuMuon phieuMuon) {
        return phieuMuonRepository.save(phieuMuon);
    }

    @Override
    public PhieuMuon update(Integer id) {
        PhieuMuon phieuMuon = phieuMuonRepository.findById(id).orElse(null);
        if(phieuMuon != null) {
            if(phieuMuon.getTrangThai() == PhieuMuon.TrangThai.DA_TRA){
                throw new RuntimeException("Phiếu mượn này đã được trả trước đó");
            }
            // Thay đổi giá trị của bảng phieumuon
            phieuMuon.setNgayTra(new Date());
            phieuMuon.setTrangThai(PhieuMuon.TrangThai.DA_TRA);
            // Cật nhập sách
            List<ChiTietPhieuMuon> chiTietPhieuMuons  = chiTietPhieuMuonRepository.findAllById(Collections.singleton(id)).stream().toList();
            for(ChiTietPhieuMuon chiTietPhieuMuon : chiTietPhieuMuons) {
                Sach sach = sachRepository.findById(chiTietPhieuMuon.getSach().getMaSach()).orElse(null);
                sach.setSoLuong(chiTietPhieuMuon.getSoLuong()+sach.getSoLuong());
                sachRepository.save(sach);
            }
            phieuMuonRepository.save(phieuMuon);
        }
        return phieuMuon;
    }

}
