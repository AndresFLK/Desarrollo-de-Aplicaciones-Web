package com.tienda_l.controller;

import java.util.Arrays;

import javax.management.AttributeValueExp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.engine.AttributeName;

import com.tienda_l.DAO.Dao;

import domain.Cliente;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ClienteController {

    @Autowired
    private Dao clienteDao;

    @GetMapping("/")
    public String Inicio(Model model) {
        var mensaje = "Hola jovani este es jovani";
        model.addAttribute("mensaje", mensaje);

        var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }
}
