package com.example.librarymanagement.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "phieu_muon")
public class PhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_phieu_muon")
    Integer maPhieuMuon;

    @Column(name = "ngay_muon")
    Date ngayMuon;

    @Column(name = "ngay_tra")
    Date ngayTra;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai")
    TrangThai trangThai = TrangThai.DANG_MUON;

    public enum TrangThai {
        DANG_MUON,
        DA_TRA
    }

    @ManyToOne
    @JoinColumn(name = "ma_doc_gia", referencedColumnName = "ma_doc_gia")
    DocGia docGia;
}