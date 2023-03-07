package com.practica.practica.SERVICES;

import java.util.List;

import com.practica.practica.domain.Cliente;

public interface ClienteServices {
    public List<Cliente> getCliente();

    public Cliente getCliente(Cliente cliente);

    public void save(Cliente cliente);

    public void delete(Cliente cliente);
}
