package com.example.librarymanagement.services;

import com.example.librarymanagement.dto.DocGiaDTO;
import com.example.librarymanagement.models.ChiTietPhieuMuon;
import com.example.librarymanagement.models.DocGia;
import org.hibernate.sql.Update;

import java.util.Optional;

public interface IDocGiaService {
    Optional<DocGia> findDocGiaByMaDocGia(Integer maDocGia);
    DocGia updateDocgiaDTO(DocGiaDTO dto);
}
