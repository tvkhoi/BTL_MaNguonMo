// Sach.java
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
@Table(name = "sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sach")
    Integer maSach;

    @Column(name = "tieu_de")
    String tieuDe;

    @Column(name = "tac_gia")
    String tacGia;

    @Column(name = "the_loai")
    String theLoai;

    @Column(name = "so_luong")
    int soLuong;

    @Column(name = "nha_xuat_ban")
    String nhaXuatBan;

    @Column(name = "nam_xuat_ban")
    @Temporal(TemporalType.DATE)
    Date namXuatBan;
}