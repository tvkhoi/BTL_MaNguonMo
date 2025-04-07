package com.example.librarymanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public enum ErrorCode {
    INVALID_DATA(400, "Thông tin không hợp lệ",HttpStatus.NOT_FOUND),
    SACH_NOT_EXITS(40401, "Sach khong ton tai", HttpStatus.NOT_FOUND),
    DOCGIA_NOT_EXITS(40402, "Doc gia khong ton tai",HttpStatus.NOT_FOUND),
    PHIEUMUON_NOT_EXITS(40403, "Phieu muon khong ton tai", HttpStatus.NOT_FOUND),
    CHITIETPHIEUMUON_NOT_EXITS(40404, "Chi tiet phieu muon khong ton tai", HttpStatus.NOT_FOUND);
    Integer code;
    String message;
    HttpStatus status;

}
