package com.example.librarymanagement.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ChiTietPhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maChiTietPhieuMuon", nullable = false)
    Integer maChiTietPhieuMuon;
    int soLuong = 1;

    // Quan hệ với Phiếu mượn
    @ManyToOne
    @JoinColumn(name = "maPhieuMuon", referencedColumnName = "maPhieuMuon")
    PhieuMuon phieuMuon;

    // Quan hệ với Sách
    @ManyToOne
    @JoinColumn(name = "maSach", referencedColumnName = "maSach")
    Sach sach;


}
