package com.mavidevproje.demo.service;

import com.mavidevproje.demo.entity.Province;
import com.mavidevproje.demo.exception.MyNotFoundException;
import com.mavidevproje.demo.repository.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceService {

    private final ProvinceRepository provinceRepository;

    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    public Province findById(Long id) {
        return provinceRepository.findById(id).orElseThrow(MyNotFoundException::new);
    }
}
