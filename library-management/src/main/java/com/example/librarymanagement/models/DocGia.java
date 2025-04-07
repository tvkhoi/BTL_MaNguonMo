// DocGia.java
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
@Table(name = "doc_gia")
public class DocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_doc_gia")
    Integer maDocGia;

    @Column(name = "ten_doc_gia")
    String tenDocGia;

    @Column(name = "email")
    String Email;

    @Column(name = "sdt")
    String sdt;

    @Column(name = "dia_chi")
    String diaChi;

    @Column(name = "ngay_tao")
    Date ngayTao = new Date();
}