package com.example.librarymanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class DocGiaDTO {
    private Integer maDocGia;  // Đổi từ "id" sang "maDocGia"


    @NotBlank(message = "Tên độc giả không được để trống")
    @Size(max = 255, message = "Tên độc giả không được vượt quá 255 ký tự")
    private String tenDocGia;

    @NotBlank(message = "Email không được để trống")
    @Size(max = 100, message = "Email không được vượt quá 100 ký tự")
    private String Email;

    @Size(max = 100, message = "Số điện thoại  không được vượt quá 11 ký tự")
    private String sdt;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 100, message = "Địa chỉ không được vượt quá 100 ký tự")
    private String diaChi;

    @NotNull(message = "Ngày tạo không được để trống")
    private Date ngayTao;


}

