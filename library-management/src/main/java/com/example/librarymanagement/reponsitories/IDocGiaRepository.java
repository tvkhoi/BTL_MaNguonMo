package com.example.librarymanagement.reponsitories;

import com.example.librarymanagement.models.DocGia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDocGiaRepository extends JpaRepository<DocGia, Integer> {
    Optional<DocGia> findDocGiaByMaDocGia(Integer maDocGia);
}
