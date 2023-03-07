package com.tienda_l.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Controller
public class IndexController {

    @GetMapping("/")
    public String inicio(Model model) {
        return "index";
    }

}
