package com.mavidevproje.demo.service;

import com.mavidevproje.demo.entity.District;
import com.mavidevproje.demo.exception.MyNotFoundException;
import com.mavidevproje.demo.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;

    public List<District> findByProvinceId(Long id) {
        return districtRepository.findAllByProvince_Id(id);
    }


    public District findById(Long id) {
        return districtRepository.findById(id).orElseThrow(MyNotFoundException::new);
    }


}
