package com.mavidevproje.demo.controller;
import com.mavidevproje.demo.entity.District;
import com.mavidevproje.demo.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProvinceRestController {
    private final DistrictService districtService;

    @GetMapping("/province/{id}/district")
    public List<District> provincePage(@PathVariable(name = "id") Long id) {
        return districtService.findByProvinceId(id);
    }
}
