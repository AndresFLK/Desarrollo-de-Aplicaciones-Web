package com.prueba1.prueba1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prueba1.prueba1.domain.Revista;
import com.prueba1.prueba1.service.RevistaService;

@Controller
public class RevistaController {

    @Autowired
    private RevistaService revistaService;

    public RevistaController(RevistaService revistaService) {
        this.revistaService = revistaService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("revistasBase", revistaService.getRevistaList());
        return "index";
    }

    @GetMapping("/revistaBase/eliminar/{idRevista}")
    public String clienteEliminar(Revista revista) {
        revistaService.delete(revista);
        return "redirect:/";
    }
}
