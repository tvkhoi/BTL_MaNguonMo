package com.example.librarymanagement.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhieuMuonDTO {

    @NotNull(message = "Mã độc giả không được để trống")
    Integer maDocGia;

    @NotNull(message = "Ngày trả không được để trống")
    @FutureOrPresent(message = "Ngày trả phải là hôm nay hoặc tương lai")
    Date ngayTra;

    @NotEmpty(message = "Danh sách sách mượn không được rỗng")
    List<@NotNull SachMuonDTO> danhSachSach;
}
