package com.example.librarymanagement.services;

import com.example.librarymanagement.models.Sach;

import java.util.List;

public interface ISachService {
    List<Sach> findAll();

    Sach save(Sach sach);

}

