package com.example.librarymanagement.exception;

import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ApiException extends RuntimeException {

    ErrorCode errorCode;
    public ApiException(ErrorCode errorCode) {


        super(errorCode.getMessage());
        this.errorCode = errorCode;

    }
}
