package com.example.librarymanagement.controllers;

import com.example.librarymanagement.models.Sach;
import com.example.librarymanagement.services.ISachService;
import com.example.librarymanagement.dto.ApiResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/sach")
public class SachController {
    ISachService sachService;

    @GetMapping
    public ResponseEntity<List<Sach>> getSach() {

        return ResponseEntity.ok(sachService.findAll());
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Sach>> addSach(@RequestBody Sach sach) {
        Sach savedSach = (Sach) sachService.save(sach);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<Sach>builder().data(savedSach).build());
    }






}
