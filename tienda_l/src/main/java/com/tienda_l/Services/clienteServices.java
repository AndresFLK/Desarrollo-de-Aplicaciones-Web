package com.tienda_l.Services;

import java.util.List;

import com.tienda_l.domain.Cliente;

public interface clienteServices {
    public List<Cliente> getClientes();

    public Cliente geCliente(Cliente cliente);

    public void save(Cliente cliente);

    public void delete(Cliente cliente);
}
