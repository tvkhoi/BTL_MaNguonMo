package com.example.librarymanagement.Model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
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
public class DocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDocGia", nullable = false)
    Integer maDocGia;
    String tenDocGia;
    String Email;
    String sdt;
    String diaChi;
    Date ngayTao = new Date();

    @OneToMany(mappedBy = "docGia", cascade = CascadeType.ALL)
    List<PhieuMuon> phieuMuon = new ArrayList<>();
}
