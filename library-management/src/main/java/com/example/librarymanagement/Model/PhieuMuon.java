package com.example.librarymanagement.Model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class PhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maPhieuMuon", nullable = false)
    Integer maPhieuMuon;
    Date ngayMuon;
    Date ngayTra;
    @Enumerated(EnumType.STRING) // Lưu dạng text trong DB
    TrangThai trangThai = TrangThai.DANG_MUON; // Mặc định

    public enum TrangThai {
        DANG_MUON("Đang mượn"),
        DA_TRA("Đã trả");

        private final String value;

        TrangThai(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @OneToMany(mappedBy = "phieuMuon", cascade = CascadeType.ALL)
    List<ChiTietPhieuMuon> chiTietPhieuMuons = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "maDocGia", referencedColumnName = "maDocGia")
    DocGia docGia;
}
