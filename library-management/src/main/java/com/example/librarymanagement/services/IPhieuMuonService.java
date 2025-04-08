package com.example.librarymanagement.services;

import com.example.librarymanagement.models.PhieuMuon;

import java.util.List;

public interface IPhieuMuonService {
    List<PhieuMuon> findAll();

    PhieuMuon save(PhieuMuon phieuMuon);
    PhieuMuon update(Integer id);
}
