package com.practica.practica.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.practica.practica.SERVICES.ClienteServices;
import com.practica.practica.domain.Cliente;

@Controller
public class ClienteController {

    @Autowired
    private ClienteServices clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        var texto = "mensaje backend";
        model.addAttribute("mensaje", texto);

        Cliente cliente = new Cliente("Mario", "Carlos", "marC@gmail.com", "12345678");

        model.addAttribute("cliente", cliente);

        Cliente cliente1 = new Cliente("Juan1", "perez", "j@gmail.com", "12345678");
        Cliente cliente2 = new Cliente("Juan2", "perez", "j@gmail.com", "12345678");
        Cliente cliente3 = new Cliente("Juan3", "perez", "j@gmail.com", "12345678");

        var clientesMultp = Arrays.asList(cliente1, cliente2, cliente3);
        model.addAttribute("clientesMultp", clientesMultp);

        var clientesBase = clienteService.getCliente();
        model.addAttribute("clientesBase", clientesBase);

        return "index";
    }

    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "modCliente";
    }

    @PostMapping("/cliente/guardar")
    public String clienteGuarda(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";
    }

    @GetMapping("/clienteBase/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/";
    }

    @GetMapping("/clienteBase/modificar/{idCliente}")
    public String clienteModificar(Model model, Cliente cliente) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modCliente";
    }

}
