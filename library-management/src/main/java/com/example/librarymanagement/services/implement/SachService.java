package com.example.librarymanagement.services.implement;

import com.example.librarymanagement.dto.SachDTO;
import com.example.librarymanagement.models.Sach;
import com.example.librarymanagement.reponsitories.ISachRepository;
import com.example.librarymanagement.services.ISachService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SachService implements ISachService {
    ISachRepository sachRepository;
    @Override
    public List<Sach> findAll() {
        List<Sach> list = sachRepository.findAll();
        if (list.isEmpty()) {
            throw new NoSuchElementException("Không có sách nào trong hệ thống.");
        }
        return list;
    }


    @Override
    public Sach saveDTO(SachDTO dto) {
        Sach sach = convertToEntity(dto);

        // Tìm sách theo tiêu đề và tác giả
        Optional<Sach> existingSach = sachRepository.findByTieuDeAndTacGia(dto.getTieuDe(), dto.getTacGia());

        if (existingSach.isPresent()) {
            // Nếu sách đã có, cập nhật số lượng
            Sach s = existingSach.get();
            s.setSoLuong(s.getSoLuong() + dto.getSoLuong());
            return sachRepository.save(s);
        }

        // Nếu sách chưa tồn tại, thêm mới
        return sachRepository.save(sach);
    }


    private Sach convertToEntity(SachDTO dto) {
        Sach sach = new Sach();
        sach.setTieuDe(dto.getTieuDe());
        sach.setTacGia(dto.getTacGia());
        sach.setTheLoai(dto.getTheLoai());
        sach.setSoLuong(dto.getSoLuong());
        sach.setNhaXuatBan(dto.getNhaXuatBan());
        sach.setNamXuatBan(dto.getNamXuatBan());
        return sach;
    }

}
