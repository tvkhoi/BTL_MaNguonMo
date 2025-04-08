package com.example.librarymanagement.services.implement;

import com.example.librarymanagement.dto.PhieuMuonDTO;
import com.example.librarymanagement.dto.SachMuonDTO;
import com.example.librarymanagement.models.ChiTietPhieuMuon;
import com.example.librarymanagement.models.DocGia;
import com.example.librarymanagement.models.PhieuMuon;
import com.example.librarymanagement.models.Sach;
import com.example.librarymanagement.reponsitories.IChiTietPhieuMuonRepository;
import com.example.librarymanagement.reponsitories.IDocGiaRepository;
import com.example.librarymanagement.reponsitories.IPhieuMuonRepository;
import com.example.librarymanagement.reponsitories.ISachRepository;
import com.example.librarymanagement.services.IDocGiaService;
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
    IDocGiaRepository docGiaRepository;
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

    public PhieuMuon xacNhanMuonSach(PhieuMuonDTO dto) {
        //  Kiểm tra độc giả có tồn tại không
        DocGia docGia = docGiaRepository.findById(dto.getMaDocGia())
                .orElseThrow(() -> new RuntimeException("Độc giả không tồn tại"));

        // Tạo phiếu mượn
        PhieuMuon phieuMuon = new PhieuMuon();
        phieuMuon.setDocGia(docGia);
        phieuMuon.setNgayMuon(new Date());
        phieuMuon.setNgayTra(dto.getNgayTra());
        phieuMuon.setTrangThai(PhieuMuon.TrangThai.DANG_MUON);
        phieuMuonRepository.save(phieuMuon);

        //  Với mỗi sách trong danh sách mượn
        for (SachMuonDTO sachDto : dto.getDanhSachSach()) {
            //  Tìm sách
            Sach sach = sachRepository.findById(sachDto.getMaSach())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy sách"));

            // Kiểm tra số lượng còn trong kho
            if (sach.getSoLuong() < sachDto.getSoLuong()) {
                throw new RuntimeException("Sách '" + sach.getTieuDe() + "' không đủ số lượng trong kho");
            }

            // Giảm số lượng
            sach.setSoLuong(sach.getSoLuong() - sachDto.getSoLuong());
            sachRepository.save(sach);

            //  Tạo dòng chi tiết phiếu mượn
            ChiTietPhieuMuon ct = new ChiTietPhieuMuon();
            ct.setPhieuMuon(phieuMuon);
            ct.setSach(sach);
            ct.setSoLuong(sachDto.getSoLuong());
            chiTietPhieuMuonRepository.save(ct);
        }

        return phieuMuon;
    }


}
