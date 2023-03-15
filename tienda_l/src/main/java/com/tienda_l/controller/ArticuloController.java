package com.tienda_l.controller;

import com.tienda_l.Services.articuloServices;
import com.tienda_l.domain.Articulo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private articuloServices articuloService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";
    }

    @GetMapping("/nuevo")
    public String articuloNuevo(Articulo articulo) {
        return "/articulo/modificar";
    }

    @PostMapping("/guardar")
    public String articuloGuardar(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/eliminar/{idArticulo}")
    public String articuloEliminar(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/modificar/{idArticulo}")
    public String articuloModificar(Model model, Articulo articulo) {
        articulo = articuloService.geArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }

}
