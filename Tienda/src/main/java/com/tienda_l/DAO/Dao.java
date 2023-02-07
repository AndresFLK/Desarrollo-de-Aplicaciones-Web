package com.tienda_l.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import domain.Cliente;

public interface Dao extends CrudRepository<Cliente, Long> {

}
