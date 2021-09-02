package com.mavidevproje.demo.controller;

import com.mavidevproje.demo.model.UserDTO;
import com.mavidevproje.demo.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // reigster form post request
    @PostMapping("register")
    public String registerPost(@Valid UserDTO user, RedirectAttributes redirectAttributes) {
        return registerService.registerPost(user, redirectAttributes);
    }
}
