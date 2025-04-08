package com.example.librarymanagement.services.implement;

import com.example.librarymanagement.dto.DocGiaDTO;
import com.example.librarymanagement.dto.SachDTO;
import com.example.librarymanagement.models.DocGia;
import com.example.librarymanagement.models.Sach;
import com.example.librarymanagement.reponsitories.IDocGiaRepository;
import com.example.librarymanagement.services.IDocGiaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocGiaService implements IDocGiaService {
    IDocGiaRepository docGiaRepository;


    @Override
    public Optional<DocGia> findDocGiaByMaDocGia(Integer maDocGia) {


        return docGiaRepository.findById(maDocGia);
    }

    @Override
    public DocGia updateDocgiaDTO(DocGiaDTO dto) {
        DocGia docGia = convertToEntity(dto);
        Optional<DocGia> existingDocGia = docGiaRepository.findDocGiaByMaDocGia(docGia.getMaDocGia());
        if (existingDocGia.isPresent()) {
            DocGia updatedDocGia = existingDocGia.get();
            updatedDocGia.setTenDocGia(docGia.getTenDocGia());
            updatedDocGia.setNgayTao(docGia.getNgayTao());
            updatedDocGia.setDiaChi(docGia.getDiaChi());
            updatedDocGia.setSdt(docGia.getSdt());
            updatedDocGia.setEmail(docGia.getEmail()); // Thêm dòng này để cập nhật email
            return docGiaRepository.save(updatedDocGia);
        }
        return null; // Trả về null nếu không tìm thấy độc giả
    }
    private DocGia convertToEntity(DocGiaDTO dto) {
        DocGia docGia = new DocGia();
        docGia.setMaDocGia(dto.getMaDocGia());  // Sửa từ getId() sang getMaDocGia()
        docGia.setTenDocGia(dto.getTenDocGia());
        docGia.setEmail(dto.getEmail());
        docGia.setSdt(dto.getSdt());
        docGia.setDiaChi(dto.getDiaChi());

        docGia.setNgayTao(dto.getNgayTao());
        return docGia;
    }

}
