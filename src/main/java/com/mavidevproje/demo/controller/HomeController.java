package com.mavidevproje.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("title", "Anasayfa");
        return "index";
    }
}
