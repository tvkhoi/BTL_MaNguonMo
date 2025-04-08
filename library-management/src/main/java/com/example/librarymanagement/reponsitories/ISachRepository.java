package com.example.librarymanagement.reponsitories;

import com.example.librarymanagement.models.Sach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISachRepository extends JpaRepository<Sach, Integer> {
    Optional<Sach> findByTieuDeAndTacGia(String tieude, String tacgia);


}
