package com.example.librarymanagement.reponsitories;

import com.example.librarymanagement.models.Sach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISachRepository extends JpaRepository<Sach, Integer> {

   // List<Sach> findByMaSach(Integer maSach);


}
