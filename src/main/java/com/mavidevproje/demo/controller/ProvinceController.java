package com.mavidevproje.demo.controller;

import com.mavidevproje.demo.entity.District;
import com.mavidevproje.demo.entity.Province;
import com.mavidevproje.demo.entity.User;
import com.mavidevproje.demo.entity.UserResult;
import com.mavidevproje.demo.model.SelectDTO;
import com.mavidevproje.demo.service.DistrictService;
import com.mavidevproje.demo.service.ProvinceService;
import com.mavidevproje.demo.service.UserResultService;
import com.mavidevproje.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;
    private final DistrictService districtService;
    private final UserResultService userResultService;
    private final UserService userService;

    @GetMapping("/province")
    public String provincePage(Model model) {
        model.addAttribute("title", "Seçim yapınız");
        model.addAttribute("provinces", provinceService.findAll());
        return "select";
    }

    @PostMapping("/province")
    public String provincePostPage(SelectDTO dto, Model model) {
        Province province = provinceService.findById(dto.getProvinceId());
        District district = districtService.findById(dto.getDistrictId());
        UserResult userResult = new UserResult();
        userResult.setDistrict(district);
        userResult.setProvince(province);
        User currentUser = userService.getCurrentUser();
        userResult.setUser(currentUser);
        userResultService.saveResult(userResult);

        List<UserResult> userResultList = userResultService.getAllByUserId((long) currentUser.getId());
        System.out.println(userResultList);
        model.addAttribute("province", province.getName());
        model.addAttribute("results", userResultList);
        model.addAttribute("district", district.getName());
        model.addAttribute("title", "Seçim sonuçlarınız");
        return "result";
    }


}
