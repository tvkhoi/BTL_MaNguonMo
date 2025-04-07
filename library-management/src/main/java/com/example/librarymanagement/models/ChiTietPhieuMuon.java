// ChiTietPhieuMuon.java
package com.example.librarymanagement.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "chi_tiet_phieu_muon")
public class ChiTietPhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_chi_tiet_phieu_muon")
    Integer maChiTietPhieuMuon;

    @Column(name = "so_luong")
    int soLuong = 1;

    @ManyToOne
    @JoinColumn(name = "ma_phieu_muon", referencedColumnName = "ma_phieu_muon")
    PhieuMuon phieuMuon;

    @ManyToOne
    @JoinColumn(name = "ma_sach", referencedColumnName = "ma_sach")
    Sach sach;
}