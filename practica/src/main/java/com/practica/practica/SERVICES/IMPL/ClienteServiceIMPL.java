package com.practica.practica.SERVICES.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.practica.DAO.clienteDao;
import com.practica.practica.SERVICES.ClienteServices;
import com.practica.practica.domain.Cliente;

@Service
public class ClienteServiceIMPL implements ClienteServices {

    @Autowired
    private clienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getCliente() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

}
