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
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maSach", nullable = false)
    Integer maSach;
    String tieuDe;
    String tacGia;
    String theLoai;
    int soLuong;
    String nhaXuatBan;
    @Temporal(TemporalType.DATE)
    Date namXuatBan;

    @OneToMany(mappedBy = "sach", cascade = CascadeType.ALL)
    List<ChiTietPhieuMuon> chiTietPhieuMuons = new ArrayList<>();

}
