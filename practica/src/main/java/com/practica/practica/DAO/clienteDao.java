package com.practica.practica.DAO;

import org.springframework.data.repository.CrudRepository;

import com.practica.practica.domain.Cliente;

public interface clienteDao extends CrudRepository<Cliente, Long> {

}
