package com.example.librarymanagement.services.implement;

import com.example.librarymanagement.models.Sach;
import com.example.librarymanagement.reponsitories.ISachRepository;
import com.example.librarymanagement.services.ISachService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SachService implements ISachService {
    ISachRepository sachRepository;
    @Override
    public List<Sach> findAll() {
        return sachRepository.findAll();
    }



    @Override
    public Sach save(Sach sach) {
        return sachRepository.save(sach);
    }
}
