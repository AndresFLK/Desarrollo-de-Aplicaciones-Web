package com.tienda_l.controller;

import com.tienda_l.Services.clienteServices;
import com.tienda_l.domain.Cliente;

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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private clienteServices clienteService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        var totalCredito = 0;
        for (Cliente c : clientes) {
            totalCredito += c.getCredito().getLimite();
        }

        model.addAttribute("totalCredito", totalCredito);
        return "/cliente/listado";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping("/guardarCliente")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Model model, Cliente cliente) {
        cliente = clienteService.geCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

}
