package com.tienda_l.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tienda_l.Services.articuloServices;

@Service
@Controller
public class IndexController {

    @Autowired
    private articuloServices articuloServices;

    @GetMapping("/")
    public String inicio(Model model) {
        var articulos = articuloServices.getArticulos(true);
        model.addAttribute("articulos", articulos);

        return "index";
    }

}
