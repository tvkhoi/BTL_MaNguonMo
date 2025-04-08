package com.example.librarymanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class SachDTO {
    private Integer id;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 255, message = "Tiêu đề không được vượt quá 255 ký tự")
    private String tieuDe;

    @NotBlank(message = "Tác giả không được để trống")
    @Size(max = 100, message = "Tác giả không được vượt quá 100 ký tự")
    private String tacGia;

    @Size(max = 100, message = "Nhà xuất bản không được vượt quá 100 ký tự")
    private String nhaXuatBan;

    @NotNull(message = "Năm xuất bản không được để trống")
    private Date namXuatBan;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng sách phải ít nhất là 1")
    private Integer soLuong;

    @Size(max = 100, message = "Thể loại không được vượt quá 100 ký tự")
    private String theLoai;
}
