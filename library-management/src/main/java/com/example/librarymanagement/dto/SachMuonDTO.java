package com.example.librarymanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SachMuonDTO {

    @NotNull(message = "Mã sách không được để trống")
    Integer maSach;

    @NotNull(message = "Số lượng mượn không được để trống")
    @Min(value = 1, message = "Phải mượn ít nhất 1 quyển")
    Integer soLuong;
}
